package com.athiley.devlibrary.repositories

import com.athiley.devlibrary.models.Book
import org.springframework.data.mongodb.repository.MongoRepository

interface BookRepository : MongoRepository<Book, String> {
    fun findByIsRead(isRead: Boolean): List<Book>
}
