package com.uramnoil.serverist.application.serverist.commands

import com.benasher44.uuid.Uuid
import com.uramnoil.serverist.application.serverist.Server

/**
 * A input-port of CreateServerCommandUseCase.
 */
interface CreateServerCommandInputPort {
    /**
     * Request to create a new server.
     *
     * @param ownerId       server owner's UUID
     * @param name          the name of the new server
     * @param host          the host of the new server
     * @param port          the port of the new server
     * @param description   the description of the new server
     */
    fun execute(
        ownerId: Uuid,
        name: String,
        host: String?,
        port: Int?,
        description: String
    )
}

/**
 * A output-port of CreateServerCommandUseCase
 */
interface CreateServerCommandOutputPort {
    /**
     * Handle result of request of creating a new server.
     *
     * @param result    the result of the request.
     */
    fun handle(result: Result<Server>)
}