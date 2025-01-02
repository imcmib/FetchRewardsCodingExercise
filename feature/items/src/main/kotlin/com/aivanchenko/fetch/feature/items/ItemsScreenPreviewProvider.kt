package com.aivanchenko.fetch.feature.items

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.aivanchenko.fetch.domain.model.Item
import com.aivanchenko.fetch.feature.items.ItemsContract.ViewState

class ItemsScreenPreviewProvider : PreviewParameterProvider<ViewState> {
    override val values: Sequence<ViewState>
        get() = sequenceOf(
            ViewState(
                items = (1..3L).associateWith { listId ->
                    (0..3L).map { itemId ->
                        Item(
                            id = itemId,
                            listId = listId,
                            name = "List: $listId, item $itemId"
                        )
                    }
                }
            ),
            ViewState(
                isLoading = true
            ),
            ViewState(
                error = "Failed to load items"
            )
        )
}