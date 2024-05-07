package com.meeweel.admin.app

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.meeweel.app_admin.core.navigation.NavItemMenu
import com.meeweel.app_admin.features.search.navGraphSearch
import com.meeweel.app_admin.features.menu.navGraphMenu
import com.meeweel.app_admin.core.navigation.NavigationState

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