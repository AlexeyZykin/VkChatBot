package com.alexey.vkchatbot.entity

import com.alexey.vkchatbot.model.Message

data class MessageEntity(
    val id: Int,

    val date: Int,

    val peerId: Int,

    val fromId: Int,

    val text: String,
)

fun MessageEntity.toModel() = Message(id, date, peerId, fromId, text)
