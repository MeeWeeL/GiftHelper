package com.meeweel.features.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meeweel.core.navigation.NavigationState
import com.meeweel.core.ui_base.theme.MeTheme
import com.meeweel.core.ui_components.MeCard
import com.meeweel.core.ui_components.OzonButton
import com.meeweel.core.ui_components.loadImage
import com.meeweel.domain.models.Gift
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    navigationState: NavigationState,
    viewModel: SearchViewModel = hiltViewModel(),
) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var fullInfoGift: Gift? by remember { mutableStateOf(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
    ) {
        SearchResult(
            viewModel.state.value.giftList,
            onItemClick = {
                fullInfoGift = it
                showBottomSheet = true
                scope.launch { sheetState.expand() }
            },
        )
    }

    if (showBottomSheet) {
        FullGiftInfoBottomSheet(
            sheetState = sheetState,
            gift = fullInfoGift,
            onDismissRequest = { showBottomSheet = false }
        )
    }
}

@Composable
fun SearchResult(giftList: List<Gift>?, onItemClick: (Gift) -> Unit) {
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
                    GiftCard(gift = it, onClick = { onItemClick(it) })
                }
                Spacer(modifier = Modifier.height(4.dp))
            }
        }
    }
}

@Composable
fun GiftCard(gift: Gift, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .clickable { onClick() },
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
                        painter = loadImage(model = gift.imageUrl),
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
                        gift.ozonUri?.let { uri ->
                            OzonButton(uri)
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
    GiftCard(gift) {}
}