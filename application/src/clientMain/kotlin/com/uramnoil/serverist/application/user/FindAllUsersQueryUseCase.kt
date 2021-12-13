package com.uramnoil.serverist.application.user

class FindAllUsersQueryUseCaseInput

/**
 *
 */
interface FindAllUsersQueryUseCaseInputPort {
    /**
     *
     */
    fun execute(input: FindAllUsersQueryUseCaseInput)
}

/**
 *
 */
data class FindAllUsersQueryUseCaseOutput(val result: Result<List<User>>)

/**
 *
 */
fun interface FindAllUsersQueryUseCaseOutputPort {
    /**
     *
     */
    fun handle(output: FindAllUsersQueryUseCaseOutput)
}