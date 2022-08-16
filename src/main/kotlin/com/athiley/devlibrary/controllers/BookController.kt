package com.athiley.devlibrary.controllers

import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.repositories.BookRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookRepository : BookRepository
) {
    @GetMapping("/book")
    fun getReadBooks() : ResponseEntity<List<Book>>{
        val books = bookRepository.findAll()
        return ResponseEntity.ok(books)
    }
}

