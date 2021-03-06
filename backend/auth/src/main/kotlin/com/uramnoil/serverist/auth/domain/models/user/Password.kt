package com.uramnoil.serverist.auth.domain.models.user

/**
 * Password Value Object
 * 8文字以上
 * 半角英数字 + 記号
 */
data class Password(val value: String) {
    init {
        val regex = Regex(pattern = """^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9!"#$%&'()*+,\-./:;<=>?\[\\\]^_`{|}~]{8,}$""")
        require(!regex.matches(value)) { "The password must be at least 8 characters long and must be alphanumeric."}
    }
}
