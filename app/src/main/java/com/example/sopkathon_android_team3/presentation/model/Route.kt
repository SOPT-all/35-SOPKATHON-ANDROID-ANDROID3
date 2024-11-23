package com.example.sopkathon_android_team3.presentation.model

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Storage : Route
}
