package com.alexey.vkchatbot.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class UnknownEventTypeExceptionHandler {

    @ExceptionHandler(UnknownEventTypeException::class)
    fun handleUnknownEventTypeException(e: UnknownEventTypeException): ResponseEntity<String>  {
        val errorMsg = e.message ?: "Неизвестный тип события"
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMsg)
    }
}