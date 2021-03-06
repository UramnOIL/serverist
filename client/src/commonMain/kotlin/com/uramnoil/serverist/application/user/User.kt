package com.uramnoil.serverist.serverist.application.user

import com.benasher44.uuid.Uuid
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @Contextual
    val id: Uuid,
    val accountId: String,
    val name: String,
    val description: String
)
