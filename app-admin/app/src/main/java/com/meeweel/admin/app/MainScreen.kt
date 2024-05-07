package com.meeweel.admin.app

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.meeweel.app_admin.core.navigation.NavigationState
import com.meeweel.app_admin.core.navigation.rememberNavigationState

@Composable
fun MainScreen() {
    val navigationState: NavigationState =
        rememberNavigationState()
    val snackBarHostState = remember { SnackbarHostState() }
    Scaffold(
        containerColor = Color.White,
        snackbarHost = { SnackbarHost(snackBarHostState) },
    ) { innerPadding ->
        MainNavGraph(
            navigationState = navigationState,
            snackBarHostState = snackBarHostState,
            innerPadding = innerPadding,
        )
    }
}