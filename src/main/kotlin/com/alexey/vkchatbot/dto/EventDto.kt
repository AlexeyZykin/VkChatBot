package com.alexey.vkchatbot.dto

import com.alexey.vkchatbot.model.ConfirmationEvent
import com.alexey.vkchatbot.model.Event


sealed interface EventDto

fun EventDto?.toModel(): Event? {
    return when (this) {
        is ConfirmationEventDto -> ConfirmationEvent
        is MessageNewEventDto -> this.toModel()
        else -> null
    }
}