package com.uramnoil.serverist.serverist.infrastructure.domain.repositories

import com.uramnoil.serverist.domain.serverist.models.server.Id
import com.uramnoil.serverist.domain.serverist.models.server.Server
import com.uramnoil.serverist.domain.serverist.repositories.ServerRepository
import com.uramnoil.serverist.serverist.infrastructure.Servers
import com.uramnoil.serverist.serverist.infrastructure.toDomainServer
import com.uramnoil.serverist.serverist.infrastructure.toJavaLocalDataTime
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.update

class ExposedServerRepository : ServerRepository {
    override suspend fun insert(server: Server) = kotlin.runCatching {
        newSuspendedTransaction {
            Servers.insert {
                it[id] = server.id.value
                it[ownerId] = server.ownerId.value
                it[name] = server.name.value
                it[host] = server.host?.value
                it[port] = server.port?.value
                it[description] = server.description.value
                it[createdAt] = server.createdAt.value.toJavaLocalDataTime()
            }
            commit()
        }
    }

    override suspend fun update(server: Server) = kotlin.runCatching {
        newSuspendedTransaction {
            Servers.update({ Servers.id eq server.id.value }) {
                it[name] = server.name.value
                it[host] = server.host?.value
                it[port] = server.port?.value
                it[description] = server.description.value
            }
            commit()
        }
    }

    override suspend fun delete(server: Server) = kotlin.runCatching {
        newSuspendedTransaction {
            Servers.deleteWhere { Servers.id eq server.id.value }
            commit()
        }
    }

    override suspend fun findById(id: Id): Result<Server?> = kotlin.runCatching {
        newSuspendedTransaction {
            val row = Servers.select { Servers.id eq id.value }.firstOrNull()
            row?.toDomainServer()
        }
    }
}
