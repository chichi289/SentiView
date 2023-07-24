package com.chichi289.sentiview.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun MyComposable() {
    var name by remember { mutableStateOf("Unknown") }

    Log.e("TAG", "MyComposable called")

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                name = "Red"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {
            Text("Red")
        }

        Spacer(modifier = Modifier.padding(top = 24.dp))

        Button(
            onClick = {
                name = "Yellow"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow
            )
        ) {
            Text("Yellow", color = Color.Black)
        }

        UpdateTimer(name)
    }
}

@Composable
fun UpdateTimer(value: String) {
    Log.e("TAG", "UpdateTimer called")

    val updatedValue = rememberUpdatedState(newValue =value)

    LaunchedEffect(Unit) {
        startTimer {
            Log.e("TAG", "Timer ended")
            Log.e("TAG", "Last button text was $value")
            Log.e("TAG", "Last button text with rememberUpdatedState was ${updatedValue.value}")
        }
    }
}

suspend fun startTimer(
    onTimerEnd: () -> Unit
) {
    delay(6000)
    onTimerEnd.invoke()
}


@Preview
@Composable
fun MyComposablePreview() {
    MyComposable()
}
