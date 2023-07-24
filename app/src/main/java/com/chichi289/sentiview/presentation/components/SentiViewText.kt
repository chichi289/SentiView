package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chichi289.sentiview.R
import com.chichi289.sentiview.presentation.theme.InterFontFamily

@Composable
fun SentiView() {
    Row(
        modifier = Modifier.wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(width = 38.dp, height = 32.dp),
            painter = painterResource(id = R.drawable.ic_heart), contentDescription = null
        )
        SpannableSentiViewText(
            modifier = Modifier.padding(start = 4.dp)
        )
    }
}

@Composable
fun SpannableSentiViewText(modifier: Modifier) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        ) {
            append(stringResource(R.string.txt_senti))
        }
        withStyle(
            style = SpanStyle(
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Normal
            )
        ) {
            append(stringResource(R.string.txt_view))
        }
    }

    Text(
        modifier = modifier,
        text = annotatedString,
        style = TextStyle(
            fontSize = 22.sp
        ),
        color = Color.White,
    )
}

@Preview
@Composable
fun SentiViewPreview() {
    SentiView()
}