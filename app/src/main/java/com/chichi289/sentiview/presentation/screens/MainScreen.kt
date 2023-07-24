package com.chichi289.sentiview.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.chichi289.sentiview.R
import com.chichi289.sentiview.data.models.Todo
import com.chichi289.sentiview.presentation.components.PasteButton
import com.chichi289.sentiview.presentation.components.SentiTextField
import com.chichi289.sentiview.presentation.components.SentiView
import com.chichi289.sentiview.presentation.components.ToDoItem
import com.chichi289.sentiview.presentation.navigation.Screen
import com.chichi289.sentiview.presentation.theme.Background
import com.chichi289.sentiview.presentation.theme.Purple80
import com.chichi289.sentiview.presentation.viewmodels.TodoViewModel
import com.stevdzasan.messagebar.ContentWithMessageBar
import com.stevdzasan.messagebar.MessageBarPosition
import com.stevdzasan.messagebar.rememberMessageBarState
import kotlinx.coroutines.flow.catch
import java.net.UnknownHostException
import java.util.Locale

@Composable
fun MainScreen(
    navHostController: NavHostController? = null,
    viewModel: TodoViewModel? = hiltViewModel(),
) {

    var promptText by rememberSaveable {
        mutableStateOf("")
    }

    var todosList by rememberSaveable {
        mutableStateOf<List<Todo>>(emptyList())
    }

    val errorMessage = stringResource(R.string.msg_please_enter_text)

    val messageBarState = rememberMessageBarState()

    var isInternetAvailable by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {
        if (todosList.isNotEmpty()) return@LaunchedEffect
        viewModel!!.getTodos.invoke()
            .catch {
                isInternetAvailable = false
                if (it !is UnknownHostException) {
                    messageBarState.addError(Exception(it.message))
                }
            }
            .collect {
                todosList = it
            }
    }

    ContentWithMessageBar(
        messageBarState = messageBarState,
        contentBackgroundColor = Background,
        position = MessageBarPosition.BOTTOM,
        errorContainerColor = Purple80,
        verticalPadding = 8.dp,
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxHeight(),
        ) {
            SentiView()
            SentiTextField(
                modifier = Modifier.padding(top = 30.dp),
                value = promptText,
                onValueChange = {
                    promptText = it
                }
            )
            PasteButton(
                modifier = Modifier.padding(top = 48.dp),
                onClick = {
                    if (promptText.trim().isNotEmpty()) {
                        navHostController?.navigate(
                            Screen.TranscriptScreen.passTranscriptText(
                                promptText
                            )
                        )
                    } else {
                        messageBarState.addError(Exception(errorMessage))
                    }
                })

            if (!isInternetAvailable) {
                NoInternetLottieView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, bottom = 8.dp)
                        .weight(1f),
                    assetName = "no_internet_connection.json"
                )
            } else {
                if (todosList.isEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, bottom = 8.dp)
                            .weight(1f)
                    ) {
                        items(todosList) { it ->
                            ToDoItem(
                                title = "User Id : ${it.userId}",
                                description = it.title.replaceFirstChar {
                                    if (it.isLowerCase()) it.titlecase(
                                        Locale.ROOT
                                    ) else it.toString()
                                },
                                onClick = {
                                    promptText = it.title
                                    messageBarState.addSuccess("${it.title} Clicked")
                                }
                            )
                        }
                    }
                }
            }

            /*MicButton(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .size(80.dp),
                onClick = {}
            )*/
        }
    }
}


@Composable
fun NoInternetLottieView(
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
fun MainPreview() {
    MainScreen(
        viewModel = null
    )
}