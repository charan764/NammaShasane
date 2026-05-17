package com.example.nammashasane.utils
import com.google.ai.client.generativeai.GenerativeModel

import com.example.nammashasane.BuildConfig

object GeminiHelper {

    val generativeModel =

        GenerativeModel(

            modelName = "gemini-pro",

            apiKey = BuildConfig.GEMINI_API_KEY
        )
}