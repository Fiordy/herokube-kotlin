package com.fiordes.heroku.herokube

import lombok.NoArgsConstructor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@EnableCaching
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

@RestController
class UuidController
	(
	private val repo: MegaEntityRepository
) {

	@RequestMapping(
		value = ["/populate"],
		method = [RequestMethod.GET]
	)
	@CacheEvict(value= ["megas"], allEntries=true)
	fun populate() {
		val es = mutableListOf<MegaEntity>()
		for(i in 0..500){
			println("running $i")
			var rndm = ""
			for(j in 0..5){
				rndm += UUID.randomUUID().toString()
			}
			es.add(MegaEntity(rndm, rndm, rndm))
		}
		repo.saveAll(es)
	}

	@RequestMapping(
		value = ["/findAll"],
		method = [RequestMethod.GET]
	)
	@Cacheable("megas")
	fun findAll(): Int {
		return repo.findAll().size
	}

}

interface MegaEntityRepository: JpaRepository<MegaEntity, String> {
	@Query(value = "select * from mega_table m where m.value1 = :v", nativeQuery = true)
	fun findByValue1(@Param("v") value1: String): MegaEntity
}

@NoArgsConstructor
@Entity
@Table(name = "mega_table")
data class MegaEntity(
	@Id
	@Column(name = "value1")
	val value: String,
	val value2: String,
	val value3: String
)
