package com.alexey.vkchatbot.service

import com.alexey.vkchatbot.config.VkApiConfig
import com.alexey.vkchatbot.dto.CallbackDto
import com.alexey.vkchatbot.dto.EventType
import com.alexey.vkchatbot.dto.MessageNewEvent
import com.alexey.vkchatbot.repo.VkApiRepo
import org.springframework.stereotype.Service


@Service
class VkApiEventService(
    private val vkApiConfig: VkApiConfig,
    private val vkApiClient: VkApiClient,
    private val vkApiRepo: VkApiRepo
) {

    fun onEvent(callbackDto: CallbackDto): String {
        return when (callbackDto.type) {
            EventType.CONFIRMATION -> {
                vkApiConfig.confirmation
            }

            EventType.MESSAGE_NEW -> {
                val event = callbackDto.event as MessageNewEvent
                if (!vkApiRepo.isCached(event.message.id)) {
                    vkApiRepo.saveMessage(event.message)
                    vkApiClient.sendMessage(
                        peerId = event.message.peerId,
                        message = event.message.message
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