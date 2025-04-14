package com.alexey.vkchatbot.model

import com.alexey.vkchatbot.entity.MessageEntity

data class Message(

    val id: Int,

    val date: Int,

    val peerId: Int,

    val fromId: Int,

    val text: String,

)

fun Message.toEntity() = MessageEntity(id, date, peerId, fromId, text)