package com.athiley.devlibrary

import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class AccessingDataMongodbApplication : CommandLineRunner {
	@Autowired
	private lateinit var repository: BookRepository

	override fun run(vararg args: String) {

		repository.save(Book("Sapiens", false, 9780062316097))
		repository.save(Book("Por si las voces vuelven", true, 8408249215))
		repository.save(Book("Travessuras da menina má", true, 8573028084))

		val readBooks = repository.findByIsRead(true)
		println(readBooks)
	}

	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			SpringApplication.run(AccessingDataMongodbApplication::class.java, *args)
		}
	}
}
