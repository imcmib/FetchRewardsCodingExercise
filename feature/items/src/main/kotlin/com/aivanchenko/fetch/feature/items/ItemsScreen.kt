package com.aivanchenko.fetch.feature.items

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.aivanchenko.fetch.feature.items.ItemsContract.ViewEvent
import com.aivanchenko.fetch.feature.items.ItemsContract.ViewState
import com.aivanchenko.fetch.presentation.theme.FetchRewardsCodingExerciseTheme

@Composable
fun ItemsScreen(
    modifier: Modifier = Modifier,
) {
    val viewModel: ItemsViewModel = hiltViewModel()
    val viewState by viewModel.viewStateFlow.collectAsStateWithLifecycle()

    ItemsScreen(
        modifier = modifier,
        viewState = viewState,
        onEvent = viewModel::onEvent,
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ItemsScreen(
    modifier: Modifier = Modifier,
    viewState: ViewState,
    onEvent: (ViewEvent) -> Unit,
) {
    LaunchedEffect(key1 = Unit) {
        onEvent(ViewEvent.OnInit)
    }

    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        if (viewState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else if (viewState.error != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .padding(all = 16.dp),
                    text = viewState.error,
                    style = MaterialTheme.typography.headlineMedium
                )

                TextButton(
                    onClick = { onEvent(ViewEvent.OnRetryClick) }
                ) { }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = innerPadding)
                    .consumeWindowInsets(paddingValues = innerPadding),
                contentPadding = PaddingValues(all = 16.dp),
                verticalArrangement = Arrangement.spacedBy(space = 16.dp)
            ) {
                viewState.items.forEach { (listId, items) ->
                    stickyHeader(
                        key = listId
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(color = MaterialTheme.colorScheme.background)
                                .padding(8.dp),
                            text = "List $listId",
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }

                    items(
                        items = items,
                        key = { "${listId}_${it.id}" }
                    ) { item ->
                        ItemCard(
                            modifier = Modifier
                                .fillMaxWidth(),
                            item = item
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview(
    @PreviewParameter(ItemsScreenPreviewProvider::class) viewState: ViewState
) {
    FetchRewardsCodingExerciseTheme {
        ItemsScreen(
            viewState = viewState,
            onEvent = {},
        )
    }
}
