package com.travel.vision.ims.imsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class ImsApiApplication

fun main(args: Array<String>) {
	runApplication<ImsApiApplication>(*args)
}
