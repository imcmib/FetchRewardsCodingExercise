package com.aivanchenko.fetch.data.repository

import com.aivanchenko.fetch.data.model.toItem
import com.aivanchenko.fetch.data.provider.DispatchersProvider
import com.aivanchenko.fetch.data.service.ItemsService
import com.aivanchenko.fetch.domain.model.Item
import com.aivanchenko.fetch.domain.repository.ItemsRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val dispatchersProvider: DispatchersProvider,
    private val itemsService: ItemsService
) : ItemsRepository {

    override suspend fun getItems(): List<Item> = withContext(dispatchersProvider.io) {
        itemsService.getItems().map { it.toItem() }
    }
}
