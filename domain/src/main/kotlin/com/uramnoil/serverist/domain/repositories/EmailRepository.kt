package com.uramnoil.serverist.domain.repositories

import com.uramnoil.serverist.domain.models.email.Id
import com.uramnoil.serverist.domain.models.email.User

interface EmailRepository {
    suspend fun store(user: User)
    suspend fun findById(id: Id): User
}