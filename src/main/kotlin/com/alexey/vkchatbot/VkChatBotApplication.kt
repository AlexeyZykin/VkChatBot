package com.alexey.vkchatbot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VkChatBotApplication

fun main(args: Array<String>) {
    runApplication<VkChatBotApplication>(*args)
}
