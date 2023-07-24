package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chichi289.sentiview.R
import com.chichi289.sentiview.presentation.theme.InterFontFamily
import com.chichi289.sentiview.presentation.theme.PurpleColor

@Composable
fun PasteButton(
    modifier: Modifier, onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(
            start = 12.dp, top = 8.dp, end = 12.dp, bottom = 8.dp
        ),
        colors = ButtonDefaults.buttonColors(containerColor = PurpleColor),
        onClick = onClick
    ) {
        Icon(painter = painterResource(id = R.drawable.ic_paste), contentDescription = null)
        Text(
            modifier = Modifier.padding(start = 6.dp),
            text = stringResource(R.string.txt_paste),
            style = TextStyle(
                fontSize = 16.sp, fontFamily = InterFontFamily, fontWeight = FontWeight.SemiBold
            )
        )
    }
}

@Preview
@Composable
fun PasteButtonPreview() {
    PasteButton(modifier = Modifier, onClick = {})
}