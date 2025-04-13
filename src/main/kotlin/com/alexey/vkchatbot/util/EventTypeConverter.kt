package com.alexey.vkchatbot.util

import com.alexey.vkchatbot.dto.EventType
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.util.*

@Component
class EventTypeConverter : Converter<String, EventType> {
    override fun convert(source: String): EventType? {
        try {
            return EventType.valueOf(source.uppercase(Locale.getDefault()))
        }
        catch (e: IllegalArgumentException) {
            throw IllegalArgumentException("Недопустимое значение type")
        }
    }
}