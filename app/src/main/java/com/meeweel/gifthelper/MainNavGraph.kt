package com.meeweel.gifthelper

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.meeweel.core.navigation.NavItemMenu
import com.meeweel.core.navigation.NavigationState
import com.meeweel.features.menu.navGraphMenu
import com.meeweel.features.search.navGraphSearch

@Composable
fun MainNavGraph(
    navigationState: NavigationState,
    snackBarHostState: SnackbarHostState,
    innerPadding: PaddingValues,
    testGraph: String? = null,
    testRoute: String? = null,
) {
    val startDestination = testGraph ?: NavItemMenu.GraphMenu.route
    NavHost(
        navController = navigationState.navHostController,
        startDestination = startDestination,
        route = testRoute,
    ) {
        navGraphMenu(navigationState)
        navGraphSearch(navigationState)
    }
}