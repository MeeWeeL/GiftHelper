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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
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
        MenuBox { navigationState.navigateTo(NavItemSearch.GraphSearch.route) }
    }
}

@Composable
fun ColumnScope.AdvertisingBox() {
    ScreenBox {

    }
}

@Composable
fun ColumnScope.MenuBox(onClick: () -> Unit) {
    ScreenBox {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                MeCard(
                    modifier = Modifier.fillMaxSize(),
                    marginAll = 16.dp,
                    onClick = onClick,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.width(32.dp))
                        Text(
                            fontSize = 24.sp,
                            text = "Find Gift",
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 8.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                ) {
                    MeCard(
                        modifier = Modifier.fillMaxSize(),
                        isSoon = true,
                    ) {
                        Text(text = "Favorite")
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(horizontal = 8.dp)
                ) {
                    MeCard(
                        modifier = Modifier.fillMaxSize(),
                        isSoon = true,
                    ) {
                        Text(text = "Settings")
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ) {}
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
    Column(modifier = Modifier.fillMaxSize()) {
        MenuBox {}
    }
}
