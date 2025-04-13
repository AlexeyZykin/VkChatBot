package com.alexey.vkchatbot.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:application.properties")
data class VkApiConfig(

    @Value("\${vk.api.token}")
    val token: String,

    @Value("\${vk.api.version}")
    val version: String,

    @Value("\${vk.api.secret}")
    val secretKey: String,

    @Value("\${vk.api.confirmation}")
    val confirmation: String
)
