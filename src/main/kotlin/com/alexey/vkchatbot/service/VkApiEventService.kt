package com.alexey.vkchatbot.service

import com.alexey.vkchatbot.config.VkApiConfig
import com.alexey.vkchatbot.model.Callback
import com.alexey.vkchatbot.model.EventType
import com.alexey.vkchatbot.model.MessageNewEvent
import com.alexey.vkchatbot.model.toEntity
import com.alexey.vkchatbot.repo.VkApiRepo
import org.springframework.stereotype.Service


@Service
class VkApiEventService(
    private val vkApiConfig: VkApiConfig,
    private val vkApiClient: VkApiClient,
    private val vkApiRepo: VkApiRepo
) {

    fun onEvent(callback: Callback): String {
        return when (callback.type) {
            EventType.CONFIRMATION -> {
                vkApiConfig.confirmation
            }

            EventType.MESSAGE_NEW -> {
                val event = callback.eventDto as MessageNewEvent
                if (!vkApiRepo.isCached(event.message.id)) {
                    vkApiRepo.saveMessage(event.message.toEntity())
                    vkApiClient.sendMessage(
                        peerId = event.message.peerId,
                        message = event.message.text
                    )
                }
                MESSAGE_RECEIVED_SUCCESS
            }
        }
    }

    companion object {
        private const val MESSAGE_RECEIVED_SUCCESS = "ок"
    }
}