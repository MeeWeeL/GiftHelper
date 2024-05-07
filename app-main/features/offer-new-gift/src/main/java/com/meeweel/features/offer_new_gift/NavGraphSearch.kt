package com.meeweel.features.offer_new_gift

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.meeweel.core.navigation.NavItemOffer
import com.meeweel.core.navigation.NavigationState

fun NavGraphBuilder.navGraphOffer(
    navigationState: NavigationState,
) {
    navigation(
        startDestination = NavItemOffer.ScreenOffer.route,
        route = NavItemOffer.GraphOffer.route
    ) {
        composable(NavItemOffer.ScreenOffer.route) {
            OfferScreen()
        }
    }
}