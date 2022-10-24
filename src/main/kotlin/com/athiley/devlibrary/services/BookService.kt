package com.athiley.devlibrary.services

import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService (private val bookRepository : BookRepository){
    fun fetchBooks(isRead: Boolean) : List<Book> {
        return bookRepository.findByIsRead(isRead)
    }

    fun addBook(title: String, isbn: String): Book {
        val isRead = false
        val book = Book(title, isRead, isbn)
        bookRepository.save(book)
        return book
    }

    fun deleteBook(isbn: String) {
        val bookToBeFound = bookRepository.findById(isbn)
        bookToBeFound.takeIf { it.isPresent }
            ?.get()
            ?.let { book ->
                bookRepository.delete(book)
            }
    }
}
