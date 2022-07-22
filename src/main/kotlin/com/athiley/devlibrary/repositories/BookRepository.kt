package com.athiley.devlibrary.repositories

import com.athiley.devlibrary.models.Book
import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository : MongoRepository<Book, Number> {
    fun findByIsbnId(isbnId: Number): Book?
    fun findByName(name: String): List<Book>
    fun findByIsRead(isRead: Boolean): List<Book>
}
