package com.meeweel.features.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.meeweel.core.navigation.NavItemSearch
import com.meeweel.core.navigation.NavigationState

fun NavGraphBuilder.navGraphSearch(
    navigationState: NavigationState,
) {
    navigation(
        startDestination = NavItemSearch.ScreenSearch.route,
        route = NavItemSearch.GraphSearch.route
    ) {
        composable(NavItemSearch.ScreenSearch.route) {
            SearchScreen(navigationState)
        }
    }
}