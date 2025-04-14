package com.alexey.vkchatbot.dto

import com.alexey.vkchatbot.model.EventType

enum class EventTypeDto {
    CONFIRMATION, MESSAGE_NEW
}

fun EventTypeDto.toModel() = when (this) {
    EventTypeDto.CONFIRMATION -> EventType.CONFIRMATION
    EventTypeDto.MESSAGE_NEW -> EventType.MESSAGE_NEW
}