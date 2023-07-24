package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
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
fun ScoreRangeView() {

    val scoreRangeList = ArrayList<Pair<String, Color>>().apply {
        add(Pair(stringResource(R.string.txt_positive_score_range), GreenColor))
        add(Pair(stringResource(R.string.txt_neutral_score_range), YellowColor))
        add(Pair(stringResource(R.string.txt_negative_score_range), RedColor))
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(BackgroundLight)
            .padding(top = 12.dp, bottom = 12.dp, start = 20.dp, end = 20.dp)
    ) {
        Text(
            text = stringResource(R.string.txt_score_range), color = Color.White, style = TextStyle(
                fontSize = 16.sp, fontWeight = FontWeight.SemiBold, fontFamily = InterFontFamily
            )
        )


        LazyRow(
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(scoreRangeList) { pair ->
                RangeText(scoreRangeText = pair.first, color = pair.second)
            }
        }


    }

}

@Composable
fun RangeText(scoreRangeText: String, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(size = 8.dp)
                .clip(shape = RoundedCornerShape(size = 2.dp))
                .background(color = color)
        )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = scoreRangeText,
            color = TextColorLight,
            style = TextStyle(
                fontSize = 14.sp, fontWeight = FontWeight.Normal, fontFamily = InterFontFamily
            )
        )
    }
}

@Preview
@Composable
fun ScoreRangeViewPreview() {
    ScoreRangeView()
}

@Preview
@Composable
fun RangeTextPreview() {
    RangeText(
        scoreRangeText = "0.25 - 1", color = GreenColor
    )
}

@Preview
@Composable
fun RangeTextPreview1() {
    RangeText(
        scoreRangeText = "-0.25 - 25", color = YellowColor
    )
}

@Preview
@Composable
fun RangeTextPreview2() {
    RangeText(
        scoreRangeText = "-1 - -0.25", color = RedColor
    )
}
