package com.chichi289.sentiview.presentation.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.chichi289.sentiview.R
import com.chichi289.sentiview.presentation.components.BackButton
import com.chichi289.sentiview.presentation.components.ScoreRangeView
import com.chichi289.sentiview.presentation.components.ScoreView
import com.chichi289.sentiview.presentation.components.SentiAlertDialog
import com.chichi289.sentiview.presentation.theme.GreenColor
import com.chichi289.sentiview.presentation.theme.InterFontFamily
import com.chichi289.sentiview.presentation.theme.RedColor
import com.chichi289.sentiview.presentation.theme.TextColorLight
import com.chichi289.sentiview.presentation.theme.YellowColor

@Composable
fun ResultScreen(
    navHostController: NavHostController? = null,
    moodType: String
) {

    /*BackPressHandler(onBackPressed = {
        Toast.makeText(context, "Back Pressed", Toast.LENGTH_SHORT).show()
        navHostController?.popBackStack()
    })*/

    var showAlertDialog by remember {
        mutableStateOf(false)
    }

    BackHandler(true) {
        showAlertDialog = true
    }
    if (showAlertDialog) {
        SentiAlertDialog(
            icon = R.drawable.ic_back,
            title = "Go back?",
            text = "Are you sure you want to go back?",
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),
            onConfirm = {
                showAlertDialog = false
                navHostController?.popBackStack()
            },
            onDismissRequest = {
                showAlertDialog = false
            }
        )
    }

    /* moodType
    *  H - Happy
    *  N - Neutral
    *  S - Sad
    * */
    val listOfScores = ArrayList<Triple<Float, String, Color>>().apply {
        add(Triple(0.85f, stringResource(id = R.string.txt_score), GreenColor))
        add(Triple(0.25f, stringResource(id = R.string.txt_salience), YellowColor))
        add(Triple(0.55f, stringResource(id = R.string.txt_magnitude), RedColor))
    }

    Column(
        modifier = Modifier
            //.verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 10.dp)
    ) {
        BackButton(
            modifier = Modifier.padding(start = 20.dp)
        ) {
            showAlertDialog = true
        }
        val assetName = when (moodType) {
            "H" -> "positive_emoji.json"
            "N" -> "neutral_emoji.json"
            "S" -> "negative_emoji.json"
            else -> "positive_emoji.json"
        }
        LottieView(
            modifier = Modifier
                .size(250.dp)
                .align(alignment = Alignment.CenterHorizontally),
            assetName = assetName
        )

        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 4.dp),
            text = stringResource(R.string.txt_heading),
            color = Color.White,
            style = TextStyle(
                fontSize = 24.sp, fontWeight = FontWeight.SemiBold, fontFamily = InterFontFamily
            )
        )

        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterHorizontally)
                .padding(top = 6.dp, start = 20.dp, end = 20.dp),
            text = stringResource(R.string.txt_description),
            color = TextColorLight,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp, fontWeight = FontWeight.Normal, fontFamily = InterFontFamily
            )
        )

        LazyRow(
            modifier = Modifier
                .padding(top = 36.dp, start = 20.dp, end = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            items(listOfScores) { triple ->
                ScoreView(
                    score = triple.first, borderColor = triple.third, title = triple.second
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        ScoreRangeView()

    }
}

@Composable
fun LottieView(
    modifier: Modifier, assetName: String
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset(assetName))
    val progress by animateLottieCompositionAsState(
        composition = composition, iterations = LottieConstants.IterateForever
    )

    LottieAnimation(modifier = modifier, composition = composition, progress = { progress })
}

@Preview
@Composable
fun ResultScreenPreview() {
    ResultScreen(moodType = "1")
}