package com.meeweel.core.ui_components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OzonButton(uri: Uri) {
    val context = LocalContext.current
    Button(
        modifier = Modifier.height(22.dp),
        contentPadding = PaddingValues(all = 0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        onClick = {
            val urlIntent = Intent(
                Intent.ACTION_VIEW,
                uri,
            )
            context.startActivity(urlIntent)
        },
    ) {
        Text(text = stringResource(R.string.ozon))
    }
}

@Composable
@Preview(showBackground = true)
fun OzonButtonPreview() {
    OzonButton(Uri.parse(""))
}