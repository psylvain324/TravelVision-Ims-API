package com.travel.vision.imsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaRepositories
@SpringBootApplication
class ImsApiApplication

fun main(args: Array<String>) {
	runApplication<ImsApiApplication>(*args)
}
