package com.alexey.vkchatbot.repo

import com.alexey.vkchatbot.dto.Message
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class VkApiRepo {
    private val cachedMsg = ConcurrentHashMap<Int, Message>()

    fun isCached(messageId: Int): Boolean =
        cachedMsg.containsKey(messageId)

    fun saveMessage(message: Message) {
        cachedMsg[message.id] = message
    }

    fun getCachedMessages(): List<Message> = cachedMsg.values.toList()

    fun clearAll() {
        cachedMsg.clear()
    }
}