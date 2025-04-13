package com.alexey.vkchatbot.util

import com.alexey.vkchatbot.dto.*
import com.alexey.vkchatbot.exception.UnknownEventTypeException
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import java.util.*

class CallbackDeserializer : JsonDeserializer<CallbackDto>() {
    override fun deserialize(p: JsonParser, ctxt: DeserializationContext?): CallbackDto {
        val node = p.codec.readTree<JsonNode>(p)

        val type = try {
            EventType.valueOf(node["type"].asText().uppercase(Locale.getDefault()))
        } catch (e: IllegalArgumentException) {
            throw UnknownEventTypeException("Неизвестный тип события")
        }
        val eventId = node["event_id"]?.asLong()
        val apiVersion = node["v"]?.asText()
        val groupId = node["group_id"].asLong()
        val secret = node["secret"]?.asText()

        val event = when (type) {
            EventType.CONFIRMATION -> ConfirmationEvent
            EventType.MESSAGE_NEW -> {
                val messageNode = node["object"]["message"]
                MessageNewEvent(
                    message = Message(
                        id = messageNode["id"].asInt(),
                        date = messageNode["date"].asInt(),
                        peerId = messageNode["peer_id"].asInt(),
                        fromId = messageNode["from_id"].asInt(),
                        message = messageNode["text"].asText()
                    )
                )
            }
        }

        return CallbackDto(type, eventId, apiVersion, event, groupId, secret)
    }
}