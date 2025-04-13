package com.alexey.vkchatbot.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient


@Configuration
class VkClientConfig(
    @Value("\${vk.api.url}")
    private val baseUrl: String
) {

    @Bean
    fun vkRestClient(): RestClient = RestClient.builder()
        .baseUrl(baseUrl)
        .build()

}