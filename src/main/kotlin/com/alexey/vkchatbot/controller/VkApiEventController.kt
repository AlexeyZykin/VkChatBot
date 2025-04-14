package com.alexey.vkchatbot.controller

import com.alexey.vkchatbot.dto.CallbackDto
import com.alexey.vkchatbot.dto.toModel
import com.alexey.vkchatbot.service.VkApiEventService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/v1/callbacks")
class VkApiEventController(
    private val vkApiEventService: VkApiEventService
) {


    @PostMapping
    fun sendCallback(@RequestBody callbackDto: CallbackDto) : ResponseEntity<String> {
        return ResponseEntity.status(HttpStatus.OK).body(vkApiEventService.onEvent(callbackDto.toModel()))
    }

}