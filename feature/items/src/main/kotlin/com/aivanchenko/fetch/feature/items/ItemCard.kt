package com.aivanchenko.fetch.feature.items

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aivanchenko.fetch.domain.model.Item
import com.aivanchenko.fetch.presentation.theme.FetchRewardsCodingExerciseTheme

@Composable
fun ItemCard(
    modifier: Modifier = Modifier,
    item: Item
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(space = 8.dp)
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = "List ID: ${item.listId}",
                style = MaterialTheme.typography.bodySmall
            )

            Text(
                text = "Item ID: ${item.id}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    FetchRewardsCodingExerciseTheme {
        ItemCard(
            item = Item(
                id = 1,
                listId = 1,
                name = "Item 1"
            )
        )
    }
}
