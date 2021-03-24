package com.uramnoil.serverist.domain.service.models.user

data class Name(val value: String) {
    init {
        if (value.isBlank()) {
            throw IllegalArgumentException("空白は代入できません。")
        }
    }
}