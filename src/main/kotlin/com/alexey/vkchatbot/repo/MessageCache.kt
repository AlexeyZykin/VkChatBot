package com.alexey.vkchatbot.repo

import com.alexey.vkchatbot.entity.MessageEntity
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap

@Repository
class MessageCache {
    private val cachedMsg = ConcurrentHashMap<Int, MessageEntity>()

    fun tryCacheMessage(message: MessageEntity): Boolean {
        return cachedMsg.putIfAbsent(message.id, message) == null
    }

    fun getCachedMessages(): List<MessageEntity> = cachedMsg.values.toList()

    fun clearAll() {
        cachedMsg.clear()
    }
}