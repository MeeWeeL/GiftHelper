package com.meeweel.core.navigation

sealed class NavItemMenu(
    val route: String,
) {

    data object GraphMenu : NavItemMenu(
        route = "graph_menu"
    )

    data object ScreenMenu : NavItemMenu(
        route = "screen_menu"
    )
}
