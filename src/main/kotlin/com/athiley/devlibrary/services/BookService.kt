package com.athiley.devlibrary.services

import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService (private val bookRepository : BookRepository){
    fun fetchBooks(isRead: Boolean) : List<Book> {
        return bookRepository.findByIsRead(isRead)
    }
}
