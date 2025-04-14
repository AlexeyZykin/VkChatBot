package com.alexey.vkchatbot.repo

import com.alexey.vkchatbot.entity.MessageEntity
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class VkApiRepo {
    private val cachedMsg = ConcurrentHashMap<Int, MessageEntity>()

    fun isCached(messageId: Int): Boolean =
        cachedMsg.containsKey(messageId)

    fun saveMessage(message: MessageEntity) {
        cachedMsg[message.id] = message
    }

    fun getCachedMessages(): List<MessageEntity> = cachedMsg.values.toList()

    fun clearAll() {
        cachedMsg.clear()
    }
}