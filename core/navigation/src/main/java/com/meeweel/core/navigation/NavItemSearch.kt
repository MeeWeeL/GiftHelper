package com.meeweel.core.navigation

sealed class NavItemSearch(
    val route: String,
) {

    data object GraphSearch : NavItemSearch(
        route = "graph_search"
    )

    data object ScreenSearch : NavItemSearch(
        route = "screen_search"
    )
}
