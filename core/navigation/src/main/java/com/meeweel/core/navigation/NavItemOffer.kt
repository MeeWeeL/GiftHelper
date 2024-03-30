package com.meeweel.core.navigation

sealed class NavItemOffer(
    val route: String,
) {

    data object GraphOffer : NavItemOffer(
        route = "graph_offer"
    )

    data object ScreenOffer : NavItemOffer(
        route = "screen_offer"
    )
}
