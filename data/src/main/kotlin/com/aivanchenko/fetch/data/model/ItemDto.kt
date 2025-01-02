package com.aivanchenko.fetch.data.model

import com.aivanchenko.fetch.domain.model.Item
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemDto(
    @SerialName("id")
    val id: Long,

    @SerialName("listId")
    val listId: Long,

    @SerialName("name")
    val name: String?
)

fun ItemDto.toItem() = Item(
    id = id,
    listId = listId,
    name = name.orEmpty()
)
