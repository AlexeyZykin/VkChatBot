package com.alexey.vkchatbot.dto

import com.alexey.vkchatbot.model.Message

data class MessageDto(

    val id: Int,

    val date: Int,

    val peerId: Int,

    val fromId: Int,

    val text: String,
)

fun MessageDto.toModel() = Message(id, date, peerId, fromId, text)