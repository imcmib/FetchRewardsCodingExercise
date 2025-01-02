package com.aivanchenko.fetch.data.service

import com.aivanchenko.fetch.data.model.ItemDto
import retrofit2.http.GET

interface ItemsService {

    @GET("hiring.json")
    suspend fun getItems(): List<ItemDto>
}
