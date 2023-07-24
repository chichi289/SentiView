package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chichi289.sentiview.R

@Composable
fun BackButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    IconButton(
        modifier = modifier.size(50.dp),
        onClick = onClick
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            tint = Color.Unspecified,
            contentDescription = null
        )
    }
}


@Preview
@Composable
fun BackButtonPreview() {
    BackButton{

    }
}