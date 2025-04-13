package com.alexey.vkchatbot.dto

import com.alexey.vkchatbot.util.CallbackDeserializer
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(using = CallbackDeserializer::class)
data class CallbackDto(

    val type: EventType,

    val eventId: Long?,

    val apiVersion: String?,

    val event: Event?,

    val groupId: Long,

    val secret: String?

)
