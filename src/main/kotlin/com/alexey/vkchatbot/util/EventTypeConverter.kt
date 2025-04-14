package com.alexey.vkchatbot.util

import com.alexey.vkchatbot.dto.EventTypeDto
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.*

@Component
class EventTypeConverter : Converter<String, EventTypeDto> {
    override fun convert(source: String): EventTypeDto? {
        try {
            return EventTypeDto.valueOf(source.uppercase(Locale.getDefault()))
        }
        catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Недопустимое значение type")
        }
    }
}