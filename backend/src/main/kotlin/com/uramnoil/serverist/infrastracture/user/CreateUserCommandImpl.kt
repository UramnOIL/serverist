package com.uramnoil.serverist.infrastracture.user

import com.uramnoil.serverist.application.user.commands.CreateUserCommand
import com.uramnoil.serverist.domain.user.models.AccountId
import com.uramnoil.serverist.domain.user.models.Description
import com.uramnoil.serverist.domain.user.models.Email
import com.uramnoil.serverist.domain.user.models.Name
import com.uramnoil.serverist.domain.user.services.CreateUserService

class CreateUserCommandImpl(
    private val createUserService: CreateUserService
) : CreateUserCommand {
    override suspend fun execute(
        accountId: String,
        email: String,
        hashedPassword: String,
        name: String,
        description: String
    ) {
        createUserService.new(
            AccountId(accountId),
            Email(email),
            com.uramnoil.serverist.domain.kernel.models.HashedPassword(hashedPassword),
            Name(name),
            Description(description)
        )
    }
}