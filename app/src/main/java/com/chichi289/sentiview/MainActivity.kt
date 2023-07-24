package com.chichi289.sentiview

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.chichi289.sentiview.presentation.components.Test
import com.chichi289.sentiview.presentation.navigation.Screen
import com.chichi289.sentiview.presentation.screens.CameraScreen
import com.chichi289.sentiview.presentation.screens.MainScreen
import com.chichi289.sentiview.presentation.screens.ResultScreen
import com.chichi289.sentiview.presentation.screens.TranscriptScreen
import com.chichi289.sentiview.presentation.theme.Background
import com.chichi289.sentiview.presentation.theme.SentiViewTheme
import com.chichi289.sentiview.utils.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val splashScreen = installSplashScreen()
            splashScreen.setKeepOnScreenCondition {
                true
            }
            lifecycleScope.launch {
                delay(1500)
                splashScreen.setKeepOnScreenCondition {
                    false
                }
            }
        }
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SentiViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = Background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                        /*startDestination = "test"*/
                    ) {

                        composable("test") {
                            //MyComposable()
                            Test()
                        }

                        composable(Screen.CameraScreen.route) {
                            CameraScreen()
                        }

                        composable(Screen.MainScreen.route) {
                            MainScreen(
                                navHostController = navController
                            )
                        }
                        composable(
                            route = Screen.TranscriptScreen.route,
                            arguments = listOf(
                                navArgument(Constants.KEY_TRANSCRIPT_TEXT) {
                                    type = NavType.StringType
                                })
                        ) { backStackEntry ->
                            TranscriptScreen(
                                navHostController = navController,
                                transcriptText = backStackEntry.arguments?.getString(Constants.KEY_TRANSCRIPT_TEXT)
                                    ?: "",
                            )
                        }
                        composable(
                            route = Screen.ResultScreen.route,
                            arguments = listOf(
                                navArgument(Constants.KEY_MOOD_TYPE) {
                                    type = NavType.StringType
                                })
                        ) { backStackEntry ->
                            ResultScreen(
                                navHostController = navController,
                                moodType = backStackEntry.arguments?.getString(Constants.KEY_MOOD_TYPE)
                                    ?: "H",
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    SentiViewTheme {
        MainScreen()
    }
}