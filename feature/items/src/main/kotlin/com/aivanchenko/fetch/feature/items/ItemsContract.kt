package com.aivanchenko.fetch.feature.items

import androidx.compose.runtime.Immutable
import com.aivanchenko.fetch.domain.model.Item

interface ItemsContract {

    @Immutable
    data class ViewState(
        val items: Map<Long, List<Item>> = emptyMap(),
        val isLoading: Boolean = false,
        val error: String? = null
    )

    sealed interface ViewEvent {
        data object OnInit : ViewEvent

        data object OnRetryClick : ViewEvent
    }
}
