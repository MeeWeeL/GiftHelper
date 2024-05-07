package com.meeweel.app_admin.features.menu

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.meeweel.app_admin.core.navigation.NavItemMenu
import com.meeweel.app_admin.core.navigation.NavigationState

fun NavGraphBuilder.navGraphMenu(
    navigationState: NavigationState,
) {
    navigation(
        startDestination = NavItemMenu.ScreenMenu.route,
        route = NavItemMenu.GraphMenu.route
    ) {
        composable(NavItemMenu.ScreenMenu.route) {
            MenuScreen(navigationState)
        }
    }
}