package com.athiley.devlibrary.services

import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.repositories.BookRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BookService (private val bookRepository : BookRepository){
    fun fetchBooks(isRead: Boolean) : List<Book> {
        return bookRepository.findByIsRead(isRead)
    }

    fun addBooks(title: String, isbn: String): Book {
        val isRead = false
        val book = Book(title, isRead, isbn)
        bookRepository.save(book)
        return book
    }
}
