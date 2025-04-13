package com.alexey.vkchatbot.model

import com.fasterxml.jackson.annotation.JsonProperty

data class VkSendMessageResponse(
    @JsonProperty("peer_id")
    val peerId: Int,

    @JsonProperty("message_id")
    val messageId: Int,

    @JsonProperty("conversation_message_id")
    val conversationMessageId: Int,

    @JsonProperty("error")
    val error: String
)
