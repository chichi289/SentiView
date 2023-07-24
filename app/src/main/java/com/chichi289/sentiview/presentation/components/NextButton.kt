package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chichi289.sentiview.R
import com.chichi289.sentiview.presentation.theme.PurpleColor

@Composable
fun NextButton(
    modifier: Modifier,
    onClick: () -> Unit,
) {

    Button(
        onClick = onClick,
        shape = CircleShape,
        modifier = modifier.size(80.dp),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = PurpleColor)
    ) {
        Icon(
            modifier = Modifier.size(48.dp),
            painter = painterResource(id = R.drawable.ic_arrow_forward),
            tint = Color.Unspecified,
            contentDescription = null
        )
    }

}

@Preview
@Composable
fun NextButtonPreview() {
    NextButton(modifier = Modifier, onClick = {})
}