package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.chichi289.sentiview.R
import com.chichi289.sentiview.presentation.theme.HintColor
import com.chichi289.sentiview.presentation.theme.InterFontFamily

@Composable
fun SentiTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    var isHintVisible by rememberSaveable { mutableStateOf(true) }

    LaunchedEffect(key1 = value, block = {
        isHintVisible = value.isEmpty()
    })

    Box(modifier = modifier) {
        BasicTextField(
            value = value,
            onValueChange = { newText ->
                onValueChange(newText)
            },
            modifier = Modifier.fillMaxWidth(),
            textStyle = TextStyle(
                color = HintColor,
                fontSize = 24.sp,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.SemiBold
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        if (isHintVisible) {
            Text(
                text = stringResource(id = R.string.txt_enter_text),
                color = HintColor,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = InterFontFamily,
                    fontWeight = FontWeight.SemiBold,
                )
            )
        }
    }

}

@Preview
@Composable
fun SentiTextFieldPreview() {
    SentiTextField(value = "", onValueChange = {}, modifier = Modifier)
}