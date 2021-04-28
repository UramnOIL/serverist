package com.uramnoil.serverist.domain.models.server

import com.uramnoil.serverist.domain.models.user.User

class Server internal constructor(
    val id: Id,
    var name: Name,
    val owner: User,
    var address: Address,
    var port: Port,
    var description: Description
)