package com.meeweel.features.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meeweel.core.navigation.NavigationState
import com.meeweel.core.ui_components.R
import com.meeweel.domain.models.Gift
import com.meeweel.ui_base.theme.MeTheme

@Composable
fun SearchScreen(
    navigationState: NavigationState,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val giftList = viewModel.state.value.giftList
    if (giftList == null) {
        Text(text = "No content")
    } else {
        SearchResult(giftList)
    }
}

@Composable
fun SearchResult(giftList: List<Gift>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {

        items(items = giftList) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                GiftCard(gift = it)
            }
        }
    }
}

@Composable
fun GiftCard(gift: Gift) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
            .padding(horizontal = 8.dp)
            .padding(vertical = 4.dp),
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = MeTheme.colors.cardBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(all = 4.dp),
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(100.dp),
                    shape = RoundedCornerShape(12.dp),
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painterResource(id = R.drawable.ic_soon),
                        contentDescription = null,
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Text(
                            modifier = Modifier.weight(1f),
                            text = gift.title,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500,
                            maxLines = 2,
                        )
                        Text(
                            text = "${gift.price} RUB",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.W500,
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        modifier = Modifier.fillMaxSize(),
                        text = gift.description,
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GiftCardPreview() {
    val gift = Gift(
        id = 0,
        title = "Title",
        description = "Description",
        price = 1500,
    )
    GiftCard(gift)
}