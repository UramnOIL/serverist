package com.uramnoil.serverist.infrastracture.server

import com.benasher44.uuid.Uuid
import com.uramnoil.serverist.application.server.commands.DeleteServerCommandInputPort
import com.uramnoil.serverist.domain.server.repositories.ServerRepository

class DeleteServerCommandInteractor(
    private val repository: ServerRepository,
) : DeleteServerCommandInputPort {
    override suspend fun execute(id: Uuid): Result<Unit> {
        val server = repository.findById(com.uramnoil.serverist.domain.server.models.Id(id)).getOrElse {
            return Result.failure(it)
        }

        server ?: return Result.failure(IllegalArgumentException("id: ${id}のサーバーが見つかりませんでした。"))

        return repository.delete(server)
    }
}