package com.meeweel.features.offer_new_gift

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meeweel.core.base.collectInLaunchedEffect
import com.meeweel.core.ui_components.MeDialog
import com.meeweel.features.offer_new_gift.OfferContract.Event
import kotlinx.coroutines.flow.Flow

@Composable
fun OfferScreen(
    viewModel: OfferViewModel = hiltViewModel(),
) {
    ObserveOnEffects(viewModel.effect)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        ScreenHeader()
        Spacer(modifier = Modifier.height(16.dp))
        GiftTitleTextField(
            title = viewModel.state.value.title,
            onTextChange = { text -> viewModel.setEvent(Event.OnChangeTitle(text)) },
        )
        Spacer(modifier = Modifier.height(16.dp))
        GiftPriceTextField(
            price = viewModel.state.value.price,
            onPriceChange = { value -> viewModel.setEvent(Event.OnChangePrice(value)) },
        )
        Spacer(modifier = Modifier.height(16.dp))
        GiftOzonLinkTextField(
            ozonUrl = viewModel.state.value.ozonUrl,
            onValueChange = { value -> viewModel.setEvent(Event.OnChangeOzonUrl(value)) },
        )
        Spacer(modifier = Modifier.height(16.dp))
        GiftDescriptionTextField(
            description = viewModel.state.value.description,
            onValueChange = { value -> viewModel.setEvent(Event.OnChangeDescription(value)) },
        )
        Spacer(modifier = Modifier.height(16.dp))
        PickImageFromGallery(
            actualImage = viewModel.state.value.image,
            onSetImageClick = { viewModel.setEvent(Event.OnSetImage(it)) },
        )
        Spacer(modifier = Modifier.height(16.dp))
        ElevatedButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            onClick = { viewModel.setEvent(Event.OnSendOffer) }) {
            Text(text = stringResource(R.string.offer_screen_offer_gift_button_text))
        }
    }
}

@Composable
fun ObserveOnEffects(
    screenEffect: Flow<OfferContract.Effect>,
) {
    val coroutineScope = rememberCoroutineScope()
    var openDialog by remember { mutableStateOf(false) }
    var dialogTitle by remember { mutableStateOf("") }
    var dialogText by remember { mutableStateOf("") }

    screenEffect.collectInLaunchedEffect { effect ->
        when (effect) {
            OfferContract.Effect.ShowOfferSentMessage -> {
                dialogTitle = "Ура!"
                dialogText = "Предложение отправлено успешно.\nСпасибо)"
                openDialog = true
            }

            OfferContract.Effect.ShowUnknownErrorMessage -> {
                dialogTitle = "Что-то пошло не так"
                dialogText = "Неизвестная ошибка"
                openDialog = true
            }

            is OfferContract.Effect.ShowWrongFieldMessage -> {
                dialogTitle = "Что-то пошло не так"
                dialogText = effect.message.ifBlank { "Ошибка заполнения полей" }
                openDialog = true
            }

            is OfferContract.Effect.Navigate -> {
            }
        }
    }
    if (openDialog) {
        MeDialog(
            title = dialogTitle,
            text = dialogText,
            onDismissRequest = { openDialog = false },
        )
    }
}

@Composable
fun ScreenHeader() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.offer_screen_offer_your_gift_idea),
        textAlign = TextAlign.Center,
        fontSize = 26.sp,
        fontWeight = FontWeight.W500,
    )
}

@Composable
fun GiftTitleTextField(
    title: String,
    onTextChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = title,
        onValueChange = onTextChange,
        modifier = Modifier.fillMaxWidth(),
        maxLines = 2,
        placeholder = { Text(text = stringResource(R.string.offer_screen_title)) },
    )
}

@Composable
fun GiftPriceTextField(
    price: String,
    onPriceChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = price,
        onValueChange = onPriceChange,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        placeholder = { Text(text = stringResource(R.string.offer_screen_price)) },
    )
}

@Composable
fun GiftOzonLinkTextField(
    ozonUrl: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = ozonUrl,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        placeholder = { Text(text = stringResource(R.string.offer_screen_ozon_link)) },
    )
}

@Composable
fun GiftDescriptionTextField(
    description: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = description,
        onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        minLines = 3,
        maxLines = 4,
        placeholder = { Text(text = stringResource(R.string.offer_screen_description)) },
    )
}

@Suppress("DEPRECATION")
@Composable
fun ColumnScope.PickImageFromGallery(
    actualImage: Bitmap?,
    onSetImageClick: (Bitmap?) -> Unit,
) {

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri: Uri? ->
        uri?.let {
            val bitmap: Bitmap = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images.Media.getBitmap(context.contentResolver, uri)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                ImageDecoder.decodeBitmap(source)
            }
            onSetImageClick(bitmap)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center,
    ) {
        if (actualImage == null) {
            ElevatedButton(onClick = { launcher.launch("image/*") }) {
                Text(text = stringResource(R.string.offer_screen_choose_photo))
            }
        } else {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    bitmap = actualImage.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentScale = ContentScale.Inside,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                ) {
                    ElevatedButton(
                        onClick = { onSetImageClick(null) },
                    ) {
                        Text(text = stringResource(R.string.offer_screen_delete_photo))
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    ElevatedButton(
                        onClick = { launcher.launch("image/*") },
                    ) {
                        Text(text = stringResource(R.string.offer_screen_change_photo))
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ScreenHeaderPreview() {
    ScreenHeader()
}

@Composable
@Preview(showBackground = true)
fun GiftTitleTextFieldPreview() {
    GiftTitleTextField(
        title = "Title",
        onTextChange = {},
    )
}

@Composable
@Preview(showBackground = true)
fun GiftPriceTextFieldPreview() {
    GiftPriceTextField(
        price = "Title",
        onPriceChange = {},
    )
}

@Composable
@Preview(showBackground = true)
fun GiftOzonLinkTextFieldPreview() {
    GiftOzonLinkTextField(
        ozonUrl = "Title",
        onValueChange = {},
    )
}

@Composable
@Preview(showBackground = true)
fun GiftDescriptionTextFieldPreview() {
    GiftDescriptionTextField(
        description = "Title",
        onValueChange = {},
    )
}

@Composable
@Preview(showBackground = true)
fun PickImageFromGalleryPreview() {
    Column {
        PickImageFromGallery(
            actualImage = null,
            onSetImageClick = {},
        )
    }
}