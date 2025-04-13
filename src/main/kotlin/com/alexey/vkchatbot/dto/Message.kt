package com.alexey.vkchatbot.dto

data class Message(

    val id: Int,

    val date: Int,

    val peerId: Int,

    val fromId: Int,

    val message: String,
)
