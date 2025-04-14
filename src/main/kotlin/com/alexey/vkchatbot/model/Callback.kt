package com.alexey.vkchatbot.model

import com.alexey.vkchatbot.dto.EventDto
import com.alexey.vkchatbot.dto.EventTypeDto

data class Callback(

    val type: EventType,

    val eventId: Long?,

    val apiVersion: String?,

    val eventDto: Event?,

    val groupId: Long,

    val secret: String?
)