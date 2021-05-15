package com.uramnoil.serverist.infrastracture.user

import com.uramnoil.serverist.application.user.User
import com.uramnoil.serverist.application.user.queries.FindAllUsersQuery
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction

class ExposedFindAllUsersQuery : FindAllUsersQuery {
    override suspend fun execute(): List<User> {
        val result = newSuspendedTransaction {
            Users.selectAll()
        }

        return result.map {
            User(it[Users.id].value, it[Users.accountId], it[Users.name], it[Users.description])
        }
    }
}