package com.chichi289.sentiview.presentation.navigation

import com.chichi289.sentiview.utils.Constants.KEY_MOOD_TYPE
import com.chichi289.sentiview.utils.Constants.KEY_TRANSCRIPT_TEXT

sealed class Screen(val route: String) {
    object MainScreen : Screen("main")
    object TranscriptScreen : Screen("transcript/{$KEY_TRANSCRIPT_TEXT}") {
        fun passTranscriptText(transcriptText: String): String {
            return "transcript/$transcriptText"
        }
    }

    object ResultScreen : Screen("result/{$KEY_MOOD_TYPE}") {
        fun passMoodType(moodType: String): String {
            return "result/$moodType"
        }
    }

    object CameraScreen:Screen("camera")
}