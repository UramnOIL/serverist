package com.uramnoil.serverist.application.authenticated

import com.benasher44.uuid.Uuid

/**
 * サインアップ用ユースケース
 * クライアントサイドで使用
 */

/**
 *
 */
fun interface SignupUseCaseInputPort {
    /**
     *
     */
    fun execute(email: String, password: String)
}

/**
 *
 */
fun interface SignupUseCaseOutputPort {
    /**
     *
     */
    fun handle(result: Result<Uuid>)
}