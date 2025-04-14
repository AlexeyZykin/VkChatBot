package com.alexey.vkchatbot.dto

import com.alexey.vkchatbot.model.Callback
import com.alexey.vkchatbot.util.CallbackDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(using = CallbackDeserializer::class)
data class CallbackDto(

    val type: EventTypeDto,

    val eventId: Long?,

    val apiVersion: String?,

    val eventDto: EventDto?,

    val groupId: Long,

    val secret: String?

)

fun CallbackDto.toModel() = Callback(type.toModel(), eventId, apiVersion, eventDto?.toModel(), groupId, secret)
