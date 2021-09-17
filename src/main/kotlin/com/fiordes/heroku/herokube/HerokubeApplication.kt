package com.fiordes.heroku.herokube

import com.fiordes.heroku.herokube.api.UserE
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@SpringBootApplication
class HerokubeApplication

fun main(args: Array<String>) {
	runApplication<HerokubeApplication>(*args)
}


interface TestApi {

	@RequestMapping("/isAlive")
	fun testMe(): String
}

@RestController class TestController: TestApi {
	override fun testMe(): String {
		return "I'm alive and running!";
	}
}