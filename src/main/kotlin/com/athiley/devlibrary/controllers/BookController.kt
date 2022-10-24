package com.athiley.devlibrary.controllers

import com.athiley.devlibrary.controllers.dto.AddBookRequest
import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.services.BookService
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

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
    @CrossOrigin(origins = ["http://127.0.0.1:5173"])
    fun addBook(@RequestBody addBookRequest : AddBookRequest) : ResponseEntity<Book>{
        val book = bookService.addBook(addBookRequest.title, addBookRequest.isbn)

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(book)
    }

    @DeleteMapping("/{isbn}")
    fun deleteBook(@PathVariable("isbn") isbn : String) : ResponseEntity<Unit>{
        bookService.deleteBook(isbn)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}

