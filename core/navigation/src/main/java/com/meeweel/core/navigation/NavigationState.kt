package com.meeweel.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

class NavigationState(
    val navHostController: NavHostController,
) {

    fun navigateTo(
        route: String,
        startDestination: String = navHostController.currentBackStackEntry?.destination?.route
            ?: "screen_menu",
        // параметр excludeStartDestination указывает сохранить ли startDestination в backStack
        // из графа навигации он будет полностью исключен.
        excludeStartDestination: Boolean = false,
    ) {
        Log.d("NavigationState", "route=$route")
        navHostController.navigate(route) {
            popUpTo(startDestination) {
                saveState = true
                inclusive = excludeStartDestination
            }
            // в верхней части обратного стека будет не более одной копии данного пункта назначения
            launchSingleTop = true
            restoreState = true
        }
    }

    fun popBackStack() {
        navHostController.popBackStack()
    }

    fun popBackStack(destinationId: Int, inclusive: Boolean) {
        navHostController.popBackStack(destinationId, inclusive)
    }
}

@Composable
fun rememberNavigationState(
    navHostController: NavHostController = rememberNavController(),
): NavigationState {
    return remember {
        NavigationState(navHostController)
    }
}
