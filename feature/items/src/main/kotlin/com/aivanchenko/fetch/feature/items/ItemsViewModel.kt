package com.aivanchenko.fetch.feature.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aivanchenko.fetch.domain.repository.ItemsRepository
import com.aivanchenko.fetch.feature.items.ItemsContract.ViewEvent
import com.aivanchenko.fetch.feature.items.ItemsContract.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    private val _viewStateFlow = MutableStateFlow(ViewState())
    val viewStateFlow = _viewStateFlow.asStateFlow()

    fun onEvent(event: ViewEvent) {
        when (event) {
            is ViewEvent.OnInit -> onInit()
            is ViewEvent.OnRetryClick -> onInit()
        }
    }

    private fun onInit() {
        viewModelScope.launch {
            _viewStateFlow.update { it.copy(isLoading = true, error = null) }
            runCatching {
                itemsRepository.getItems()
                    .filter { it.name.isNotBlank() } // Exclude items with blank or null names
                    .groupBy { it.listId } // Group by listId
                    .mapValues { entry ->
                        entry.value.sortedBy { it.name } // Sort items within each group by name
                    }
                    .toSortedMap() // Sort groups by listId
            }.onSuccess { items ->
                _viewStateFlow.update { it.copy(items = items, isLoading = false) }
            }.onFailure { exception ->
                _viewStateFlow.update { it.copy(isLoading = false, error = exception.message) }
            }
        }
    }
}
