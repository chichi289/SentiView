package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chichi289.sentiview.R
import com.chichi289.sentiview.presentation.theme.BackgroundLight
import com.chichi289.sentiview.presentation.theme.GreenColor
import com.chichi289.sentiview.presentation.theme.InterFontFamily
import com.chichi289.sentiview.presentation.theme.RedColor
import com.chichi289.sentiview.presentation.theme.TextColorLight
import com.chichi289.sentiview.presentation.theme.YellowColor

@Composable
fun ScoreView(
    score: Float,
    borderColor: Color,
    title: String
) {
    Column(
        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .width(80.dp)
                .height(80.dp)
                .background(BackgroundLight, shape = CircleShape)
                .border(3.dp, borderColor, shape = CircleShape)
                .wrapContentHeight(
                    align = Alignment.CenterVertically
                ),
            text = score.toString(),
            color = Color.White,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp, fontWeight = FontWeight.SemiBold, fontFamily = InterFontFamily
            )
        )

        Text(
            modifier = Modifier.padding(top = 11.dp),
            text = title,
            color = TextColorLight,
            style = TextStyle(
                fontSize = 14.sp, fontWeight = FontWeight.SemiBold, fontFamily = InterFontFamily
            )
        )
    }


}

@Preview
@Composable
fun ScoreViewPreview() {
    ScoreView(
        score = 0.80f,
        borderColor = GreenColor,
        title = stringResource(R.string.txt_score)
    )
}

@Preview
@Composable
fun ScoreViewPreview1() {
    ScoreView(
        score = 0.25f,
        borderColor = YellowColor,
        title = stringResource(R.string.txt_salience)
    )
}

@Preview
@Composable
fun ScoreViewPreview2() {
    ScoreView(
        score = 0.50f,
        borderColor = RedColor,
        title = stringResource(R.string.txt_magnitude)
    )
}