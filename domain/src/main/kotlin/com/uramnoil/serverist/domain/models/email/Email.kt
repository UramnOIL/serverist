package com.uramnoil.serverist.domain.models.email

data class Email(val value: String) {
    init {
        if (value.length > 255) {
            throw IllegalArgumentException("255文字以下にしてください。")
        }
    }
}