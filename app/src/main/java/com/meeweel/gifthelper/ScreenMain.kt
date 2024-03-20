package com.meeweel.gifthelper

import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.meeweel.core.navigation.NavigationState
import com.meeweel.core.navigation.rememberNavigationState

@Composable
@Preview
fun MainScreen(
    testRoute: String? = null,
    testGraph: String? = null,
) {
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
            testRoute = testRoute,
            testGraph = testGraph,
        )
    }
}
