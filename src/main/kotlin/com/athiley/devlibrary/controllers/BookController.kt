package com.athiley.devlibrary.controllers

import com.athiley.devlibrary.controllers.dto.AddBookRequest
import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.services.BookService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/book")
class BookController(
    private val bookService: BookService
) {
    @GetMapping
    fun getReadBooks(@RequestParam("isRead", required=false, defaultValue="false")isRead: Boolean) : ResponseEntity<List<Book>>{
        val books = bookService.fetchBooks(isRead)
        val responseHeaders = HttpHeaders()
        responseHeaders.set("Access-Control-Allow-Origin",
            "*");

        return ResponseEntity.ok()
            .headers(responseHeaders)
            .body(books)
    }
    @PostMapping
    fun addBook(@RequestBody addBookRequest : AddBookRequest) : ResponseEntity<Book>{
        val book = bookService.addBooks(addBookRequest.title, addBookRequest.isbn)
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(book)
    }
}

