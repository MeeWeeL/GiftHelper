package com.meeweel.app_admin.features.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.meeweel.app_admin.core.navigation.NavItemSearch
import com.meeweel.app_admin.core.navigation.NavigationState

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