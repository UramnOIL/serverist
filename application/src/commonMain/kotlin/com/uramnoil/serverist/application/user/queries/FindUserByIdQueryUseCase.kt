package com.uramnoil.serverist.application.user.queries

import com.uramnoil.serverist.application.user.User
import java.util.*

/**
 *
 */
interface FindUserByIdQueryUseCaseInputPort {
    /**
     *
     */
    fun execute(id: UUID)
}

/**
 *
 */
fun interface FindUserByIdQueryUseCaseOutputPort {
    /**
     *
     */
    fun handle(result: Result<User?>)
}