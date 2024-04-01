package com.meeweel.features.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meeweel.core.navigation.NavItemOffer
import com.meeweel.core.navigation.NavItemSearch
import com.meeweel.core.navigation.NavigationState
import com.meeweel.core.ui_components.MeCard

@Composable
fun MenuScreen(
    navigationState: NavigationState,
    viewModel: MenuViewModel = hiltViewModel(),
) {
    Column(modifier = Modifier.fillMaxSize()) {
        AdvertisingBox()
        MenuBox(
            onFindClick = { navigationState.navigateTo(NavItemSearch.GraphSearch.route) },
            onOfferClick = { navigationState.navigateTo(NavItemOffer.GraphOffer.route) },
        )
    }
}

@Composable
fun ColumnScope.AdvertisingBox() {
    ScreenBox {

    }
}

@Composable
fun ColumnScope.MenuBox(
    onFindClick: () -> Unit,
    onOfferClick: () -> Unit,
) {
    ScreenBox {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                MeCard(
                    modifier = Modifier.fillMaxSize(),
                    onClick = onFindClick,
                ) {
                    Row(
                        modifier = Modifier.padding(4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(32.dp))
                        Text(
                            fontSize = 24.sp,
                            text = stringResource(R.string.menu_screen_find_gift_idea),
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                ) {
                    MeCard(
                        modifier = Modifier.fillMaxSize(),
                        onClick = onOfferClick,
                    ) {
                        Text(text = stringResource(R.string.menu_screen_offer_gift_idea))
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {}
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ColumnScope.ScreenBox(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(weight = 1f, fill = true),
    ) {
        content()
    }
}

@Composable
@Preview(showBackground = true)
fun MenuBoxPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp),
    ) {
        MenuBox({}, {})
    }
}
