package com.chichi289.sentiview.presentation.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chichi289.sentiview.presentation.theme.SentiViewTheme

/**
 * Thin divider lines for separating content.
 */
object Dividers {
    @Composable
    fun Default(modifier: Modifier = Modifier) {
        Divider(
            thickness = 1.5.dp,
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = modifier.padding(vertical = 16.25.dp)
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    SentiViewTheme(isDarkMode = false) {
        Dividers.Default()
    }
}
