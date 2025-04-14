package com.alexey.vkchatbot.service

import com.alexey.vkchatbot.config.VkApiConfig
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
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
        val formData = createFormData(peerId, vkBotMessage)

        try {
            sendVkApiRequest(formData)
        } catch (e: HttpClientErrorException) {
            throw HttpClientErrorException(e.statusCode)
        }
    }


    private fun createFormData(peerId: Int, message: String): MultiValueMap<String, String> {
        return  LinkedMultiValueMap<String, String>().apply {
            add("peer_id", peerId.toString())
            add("message", message)
            add("random_id", Random.nextInt().toString())
            add("access_token", vkApiConfig.token)
            add("v", vkApiConfig.version)
        }
    }

    private fun sendVkApiRequest(formData: MultiValueMap<String, String>) {
        restClient.post()
            .uri(VK_API_MESSAGES_SEND_URI)
            .contentType(MediaType.APPLICATION_FORM_URLENCODED)
            .body(formData)
            .retrieve()
            .toBodilessEntity()
    }


    companion object {
        private const val VK_API_MESSAGES_SEND_URI = "https://api.vk.com/method/messages.send"
    }
}