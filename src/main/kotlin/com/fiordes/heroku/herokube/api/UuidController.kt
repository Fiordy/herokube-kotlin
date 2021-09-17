package com.fiordes.heroku.herokube.api

import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
sealed class UuidController: UuidApi {

    override fun generate(): String {
        return UUID.randomUUID().toString();
    }
}
