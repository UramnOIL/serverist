package com.uramnoil.serverist.domain.auth.unauthenticated.models

import com.uramnoil.serverist.domain.auth.kernel.model.Email
import com.uramnoil.serverist.domain.auth.kernel.model.HashedPassword


class User private constructor(
    val id: Id,
    val email: Email,
    val hashedPassword: HashedPassword,
    val authenticationCode: AuthenticationCode,
    val expiredAt: ExpiredAt,
) {
    companion object {
        fun new(
            id: Id,
            email: Email,
            hashedPassword: HashedPassword,
            authenticationCode: AuthenticationCode,
            expiredAt: ExpiredAt,
        ): Result<User> = runCatching { User(id, email, hashedPassword, authenticationCode, expiredAt) }
    }
}