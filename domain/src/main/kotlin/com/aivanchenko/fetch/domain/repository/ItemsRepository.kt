package com.aivanchenko.fetch.domain.repository

import com.aivanchenko.fetch.domain.model.Item

interface ItemsRepository {

    /**
     * Fetches the list of items.
     */
    suspend fun getItems(): List<Item>
}
