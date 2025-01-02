package com.aivanchenko.fetch.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aivanchenko.fetch.app.FetchAppNavGraph.ItemsScreen
import com.aivanchenko.fetch.feature.items.ItemsScreen

@Composable
fun FetchApp() {
    val navController = rememberNavController()

    NavHost(
        modifier = Modifier
            .fillMaxSize(),
        navController = navController,
        startDestination = ItemsScreen
    ) {
        composable<ItemsScreen> {
            ItemsScreen()
        }
    }
}
