package com.fiordes.heroku.herokube

import com.fiordes.heroku.herokube.api.UserE
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*

@SpringBootApplication
class HerokubeApplication

fun main(args: Array<String>) {
	runApplication<HerokubeApplication>(*args)
}


interface TestApi {

	@RequestMapping("/pippo")
	fun testMe(reqNum: String): String
}

class TestController: TestApi {
	override fun testMe(reqNum: String): String {
		val u = UserE(UUID.randomUUID(), "pippo", "pippo@email")
		return "I'm alive and running!";
	}
}