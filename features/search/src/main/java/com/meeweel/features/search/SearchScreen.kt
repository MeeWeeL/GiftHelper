package com.meeweel.features.search

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.meeweel.core.navigation.NavigationState
import com.meeweel.core.ui_base.theme.MeTheme
import com.meeweel.core.ui_components.MeCard
import com.meeweel.domain.models.Gift

@Composable
fun SearchScreen(
    navigationState: NavigationState,
    viewModel: SearchViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
    ) {
        SearchResult(viewModel.state.value.giftList)
    }
}

@Composable
fun SearchResult(giftList: List<Gift>?) {
    if (giftList == null) {
        repeat(7) {
            MeCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                isLoading = true,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            items(items = giftList) {
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    GiftCard(gift = it)
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun GiftCard(gift: Gift) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
    ) {
        Card(
            modifier = Modifier.fillMaxSize(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = MeTheme.colors.cardBackground)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(120.dp),
                    shape = RoundedCornerShape(0.dp),
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = rememberAsyncImagePainter(
                            model = gift.imageUrl,
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 4.dp),
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        style = MeTheme.typography.titleText,
                        text = gift.title,
                        maxLines = 1,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = gift.description,
                        style = MeTheme.typography.primaryText,
                        minLines = 2,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "${gift.price} RUB",
                            style = MeTheme.typography.titleText,
                        )
                        val context = LocalContext.current
                        gift.ozonUrl?.let { url ->
                            Button(
                                onClick = {
                                    val urlIntent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(url)
                                    )
                                    context.startActivity(urlIntent)
                                }
                            ) {
                                Text(text = stringResource(R.string.search_screen_ozon))
                            }
                        }
                    }
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