package com.uramnoil.serverist.infrastracture.server

import com.uramnoil.serverist.application.server.commands.DeleteServerCommand
import com.uramnoil.serverist.application.server.commands.DeleteServerDto
import com.uramnoil.serverist.domain.models.server.Id
import com.uramnoil.serverist.domain.repositories.NotFoundException
import com.uramnoil.serverist.domain.repositories.ServerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class DeleteServerCommandImpl(
    private val repository: ServerRepository,
    context: CoroutineContext
) : DeleteServerCommand, CoroutineScope by CoroutineScope(context) {
    override fun execute(dto: DeleteServerDto) {
        launch {
            val server = repository.findById(Id(dto.id))
                ?: throw NotFoundException("DeleteServerCommand#Execute: サーバー(Id: ${dto.id})が見つかりませんでした。")
            repository.delete(server)
        }
    }
}