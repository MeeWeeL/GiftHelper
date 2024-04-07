package com.meeweel.features.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.meeweel.core.ui_base.theme.MeTheme
import com.meeweel.core.ui_components.MeCard
import com.meeweel.core.ui_components.OzonButton
import com.meeweel.core.ui_components.loadImage
import com.meeweel.domain.models.Gift

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FullGiftInfoBottomSheet(
    sheetState: SheetState,
    gift: Gift?,
    onDismissRequest: () -> Unit,
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = onDismissRequest,
    ) {
        if (gift == null) {
            MeCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                isLoading = true,
            )
        } else {
            FullGiftInfo(gift)
        }
    }
}

@Composable
fun FullGiftInfo(gift: Gift) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = gift.title,
            textAlign = TextAlign.Center,
            style = MeTheme.typography.titleText,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(2f),
                painter = loadImage(model = gift.imageUrl),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "${gift.price} RUB",
                    style = MeTheme.typography.titleText,
                )
                Spacer(modifier = Modifier.weight(1f))
                gift.ozonUri?.let { uri ->
                    OzonButton(uri)
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            text = gift.description,
            textAlign = TextAlign.Unspecified,
            style = MeTheme.typography.primaryText,
        )
        Spacer(modifier = Modifier.height(72.dp))
    }
}