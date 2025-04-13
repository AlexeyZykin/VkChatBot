package com.alexey.vkchatbot.model

import com.fasterxml.jackson.annotation.JsonProperty
import kotlin.random.Random

data class VkSendMessageRequest(

    @JsonProperty("peer_id")
    val peerId: Int,

    @JsonProperty("message")
    val message: String,

    @JsonProperty("random_id")
    val randomId: Int = Random.nextInt(),

    @JsonProperty("access_token")
    val accessToken: String,

)
