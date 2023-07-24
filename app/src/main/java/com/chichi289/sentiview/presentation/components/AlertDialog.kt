package com.chichi289.sentiview.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties

@Composable
fun SentiAlertDialog(
    @DrawableRes icon: Int,
    title: String,
    text: String,
    properties: DialogProperties = DialogProperties(),
    onConfirm: () -> Unit,
    onDismissRequest: () -> Unit,
) {
    AlertDialog(
        icon = {
            Icon(
                painter = painterResource(id = icon),
                tint = Color.Unspecified,
                contentDescription = null
            )
        },
        title = {
            Text(text = title)
        },
        text = {
            Text(text = text)
        },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text(text = "OK")
            }
        },
        onDismissRequest = onDismissRequest,
        properties = properties
    )
}

@Preview
@Composable
fun SentiAlertDialogPreview() {
    SentiAlertDialog(
        icon = android.R.drawable.ic_dialog_alert,
        title = "Go back?",
        text = "Are you sure you want to go back?",
        onConfirm = {},
        onDismissRequest = {}
    )
}