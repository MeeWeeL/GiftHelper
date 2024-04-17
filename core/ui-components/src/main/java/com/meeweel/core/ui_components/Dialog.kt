package com.meeweel.core.ui_components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.meeweel.core.ui_base.theme.MeTheme

@Composable
fun MeDialog(
    title: String,
    text: String,
    onDismissRequest: () -> Unit,
    onConfirmRequest: (() -> Unit)? = null,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MeTheme.colors.dialogBackground),
                shape = RoundedCornerShape(8.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(
                                    MeTheme.colors.lightBlue,
                                    Color.Transparent,
                                    Color.Transparent,
                                    Color.Transparent,
                                    MeTheme.colors.lightBlue,
                                )
                            )
                        )
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = title,
                        style = MeTheme.typography.titleText,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = text,
                        style = MeTheme.typography.primaryText,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ElevatedButton(
                        modifier = Modifier
                            .align(Alignment.End)
                            .height(28.dp),
                        onClick = onDismissRequest,
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        colors = ButtonDefaults.elevatedButtonColors(contentColor = MeTheme.colors.redText),
                    ) {
                        Text(
                            text = "Закрыть",
                            style = MeTheme.typography.primaryText,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
)
fun MeDialogPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        MeDialog(
            title = "Title",
            text = "Simple text for preview",
            onDismissRequest = {},
        )
    }
}