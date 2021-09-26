package com.fiordes.heroku.herokube.api

import org.springframework.http.HttpMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@RequestMapping("/uuid")
interface UuidApi {
    /**
     * Generates a new UUID
     * @return uuid string
     */
    @RequestMapping(
        path = ["/generate"],
        method = [RequestMethod.GET]
    )
    fun generate(): String;
}