package com.athiley.devlibrary.controllers

import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.services.BookService
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController(
    private val bookService: BookService
) {
    @GetMapping("/book")
    fun getReadBooks(@RequestParam("isRead", required=false, defaultValue="false")isRead: Boolean) : ResponseEntity<List<Book>>{
        val books = bookService.fetchBooks(isRead)
        val responseHeaders = HttpHeaders()
        responseHeaders.set("Access-Control-Allow-Origin",
            "*");

        return ResponseEntity.ok()
            .headers(responseHeaders)
            .body(books)
    }
}

