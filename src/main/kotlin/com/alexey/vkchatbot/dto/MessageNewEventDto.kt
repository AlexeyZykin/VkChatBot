package com.alexey.vkchatbot.dto

import com.alexey.vkchatbot.model.MessageNewEvent


data class MessageNewEventDto(

    val messageDto: MessageDto

) : EventDto

fun MessageNewEventDto.toModel() = MessageNewEvent(this.messageDto.toModel())