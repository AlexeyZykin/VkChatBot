package com.alexey.vkchatbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class VkChatBotApplication

fun main(args: Array<String>) {
    runApplication<VkChatBotApplication>(*args)
}
