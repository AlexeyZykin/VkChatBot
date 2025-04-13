package com.alexey.vkchatbot.service

import com.alexey.vkchatbot.config.VkApiConfig
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.client.RestClient
import kotlin.random.Random


@Service
class VkApiClient(
    private val restClient: RestClient,
    private val vkApiConfig: VkApiConfig
) {

    fun sendMessage(peerId: Int, message: String) {
        val vkBotMessage = "Вы сказали: $message"
        val formData = LinkedMultiValueMap<String, String>().apply {
            add("peer_id", peerId.toString())
            add("message", vkBotMessage)
            add("random_id", Random.nextInt().toString())
            add("access_token", vkApiConfig.token)
            add("v", vkApiConfig.version)
        }
        try {
            restClient.post()
                .uri("https://api.vk.com/method/messages.send")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .body(formData)
                .retrieve()
                .toBodilessEntity()
        } catch (e: HttpClientErrorException) {
            throw HttpClientErrorException(e.statusCode)
        }
    }
}