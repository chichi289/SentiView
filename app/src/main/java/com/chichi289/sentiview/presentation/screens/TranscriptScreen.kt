package com.chichi289.sentiview.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chichi289.sentiview.R
import com.chichi289.sentiview.presentation.components.BackButton
import com.chichi289.sentiview.presentation.components.NextButton
import com.chichi289.sentiview.presentation.navigation.Screen
import com.chichi289.sentiview.presentation.theme.BackgroundLight
import com.chichi289.sentiview.presentation.theme.InterFontFamily
import com.chichi289.sentiview.presentation.theme.TextColorDark
import com.chichi289.sentiview.presentation.theme.TextColorLight

@Composable
fun TranscriptScreen(
    navHostController: NavHostController? = null,
    transcriptText: String = ""
) {

    var moodType = "H"

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        BackButton {
            navHostController?.popBackStack()
        }

        Row(modifier = Modifier.padding(top = 24.dp)) {

            Text(
                modifier = Modifier.weight(1f),
                text = stringResource(R.string.txt_your_transcript),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal
                ),
                color = TextColorDark
            )

            Icon(
                painter = painterResource(id = R.drawable.ic_copy),
                contentDescription = null,
                tint = Color.Unspecified
            )

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 19.dp)
                .background(
                    color = BackgroundLight,
                    shape = RoundedCornerShape(25.dp)
                )
                .padding(16.dp)
        ) {
            val textSize = 16.sp
            val minLines = 10
            val lineHeight = textSize * minLines / 3 // 1pt = 4/3px
            Text(
                modifier = Modifier.sizeIn(
                    minHeight = with(LocalDensity.current) {
                        (lineHeight * 3).toDp()
                    }),
                text = transcriptText,
                style = TextStyle(
                    fontSize = textSize,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.Normal
                ),
                color = TextColorLight,
                lineHeight = 24.sp,
                maxLines = 15,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Button(onClick = {
                moodType = "H"
            }) {
                Text(
                    text = stringResource(R.string.txt_happy),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Button(onClick = {
                moodType = "N"
            }) {
                Text(
                    text = stringResource(R.string.txt_neutral),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
            }

            Button(onClick = {
                moodType = "S"
            }) {
                Text(
                    text = stringResource(R.string.txt_sad),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = InterFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        NextButton(
            modifier = Modifier
                .padding(top = 24.dp)
                .align(alignment = Alignment.CenterHorizontally),
        ) {
            navHostController?.navigate(
                Screen.ResultScreen.passMoodType(moodType)
            )
        }
    }
}

@Preview
@Composable
fun TranscriptScreenPreview() {
    TranscriptScreen()
}