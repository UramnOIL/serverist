package com.uramnoil.serverist.serverist.application.server.queries

import com.benasher44.uuid.Uuid
import com.uramnoil.serverist.serverist.application.OrderBy
import com.uramnoil.serverist.serverist.application.Sort
import com.uramnoil.serverist.serverist.application.server.Server

/**
 *
 */
interface FindServersByOwnerQueryUseCaseInputPort {
    /**
     *
     */
    fun execute(ownerId: Uuid, limit: Int, offset: Long, sort: Sort, orderBy: OrderBy)
}

/**
 *
 */
fun interface FindServersByOwnerQueryUseCaseOutputPort {
    /**
     *
     */
    fun handle(result: Result<List<Server>>)
}