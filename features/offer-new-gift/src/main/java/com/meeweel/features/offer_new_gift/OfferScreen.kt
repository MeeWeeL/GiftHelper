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
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.meeweel.features.offer_new_gift.OfferContract.Event

@Composable
fun OfferScreen(
    viewModel: OfferViewModel = hiltViewModel(),
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Предложить свою идею для подарка",
            textAlign = TextAlign.Center,
            fontSize = 26.sp,
            fontWeight = FontWeight.W500,
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.state.value.title,
            onValueChange = { value ->
                viewModel.setEvent(Event.OnChangeTitle(value))
            },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 2,
            placeholder = { Text(text = "Название") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.state.value.price,
            onValueChange = { value ->
                viewModel.setEvent(Event.OnChangePrice(value))
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            placeholder = { Text(text = "Приблизительная цена") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.state.value.ozonUrl,
            onValueChange = { value ->
                viewModel.setEvent(Event.OnChangeOzonUrl(value))
            },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
            placeholder = { Text(text = "Ссылка на Ozon") },
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = viewModel.state.value.description,
            onValueChange = { value ->
                viewModel.setEvent(Event.OnChangeDescription(value))
            },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3,
            maxLines = 4,
            placeholder = { Text(text = "Описание") },
        )
        PickImageFromGallery(viewModel)
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            onClick = { viewModel.setEvent(Event.OnSendOffer) }) {
            Text(text = "Предложить")
        }
    }
}

@Suppress("DEPRECATION")
@Composable
fun ColumnScope.PickImageFromGallery(viewModel: OfferViewModel) {

    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) { uri: Uri? ->
        uri?.let {
            val bitmap: Bitmap = if (Build.VERSION.SDK_INT < 28) {
                MediaStore.Images
                    .Media.getBitmap(context.contentResolver, uri)
            } else {
                val source = ImageDecoder.createSource(context.contentResolver, uri)
                ImageDecoder.decodeBitmap(source)
            }
            viewModel.setEvent(Event.OnSetImage(bitmap = bitmap))
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .padding(16.dp),
        contentAlignment = Alignment.Center,
    ) {
        val image = viewModel.state.value.image
        if (image == null) {
            Button(onClick = { launcher.launch("image/*") }) {
                Text(text = "Выбрать фото")
            }
        } else {
            Row(modifier = Modifier.fillMaxSize()) {
                Image(
                    bitmap = image.asImageBitmap(),
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
                    Button(
                        onClick = { viewModel.setEvent(Event.OnSetImage(null)) },
                    ) {
                        Text(text = "Удалить")
                    }
                    Spacer(modifier = Modifier.height(32.dp))
                    Button(
                        onClick = { launcher.launch("image/*") },
                    ) {
                        Text(text = "Выбрать другое фото")
                    }
                }
            }
        }
    }
}