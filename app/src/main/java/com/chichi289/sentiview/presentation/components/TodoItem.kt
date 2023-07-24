package com.chichi289.sentiview.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chichi289.sentiview.presentation.theme.BackgroundLight
import com.chichi289.sentiview.presentation.theme.InterFontFamily
import com.chichi289.sentiview.presentation.theme.Purple80
import com.chichi289.sentiview.presentation.theme.TextColorLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onClick: () -> Unit
) {

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 4.dp, bottom = 4.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.elevatedCardColors(
            containerColor = BackgroundLight,
        ),
        shape = CardDefaults.elevatedShape,
        onClick = onClick
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = title,
            style = TextStyle(
                color = Purple80,
                fontSize = 14.sp,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = description,
            style = TextStyle(
                color = TextColorLight,
                fontSize = 14.sp,
                fontFamily = InterFontFamily,
                fontWeight = FontWeight.Medium
            )
        )
    }

}


@Preview
@Composable
fun ToDoItemPreview() {
    ToDoItem(
        title = "Title",
        description = "This is a description",
    ) {

    }
}