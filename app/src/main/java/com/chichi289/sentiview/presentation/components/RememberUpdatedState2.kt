package com.chichi289.sentiview.presentation.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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
import kotlinx.coroutines.delay


@Composable
fun Test() {

    var name by remember {
        mutableStateOf("Unknown")
    }

    Log.e("TAG", "Test called")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(onClick = {
            name = "Red ${System.currentTimeMillis()}"
        }) {
            Text("Click me")
        }

        Intermediate(name)

    }

}

@Composable
fun Intermediate(value: String) {
    Log.e("TAG", "Intermediate called")

    val newValue = rememberUpdatedState(value)

    LaunchedEffect(Unit) {
        logValueAfterDelay {
            Log.e("TAG", "Value is $value")
            Log.e("TAG", "New value is ${newValue.value}")
        }
    }
}

suspend fun logValueAfterDelay(onFinishDelay: () -> Unit) {
    delay(3000)
    onFinishDelay.invoke()
}

