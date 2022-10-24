package com.athiley.devlibrary.controllers

import com.athiley.devlibrary.controllers.dto.AddBookRequest
import com.athiley.devlibrary.controllers.dto.UpdateBookRequest
import com.athiley.devlibrary.models.Book
import com.athiley.devlibrary.services.BookService
import org.springframework.data.mongodb.core.query.Update
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
    fun getBooks() : ResponseEntity<List<Book>>{
        val books = bookService.fetchBooks()
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
    @PatchMapping("/{isbn}")
    fun updateBook(@PathVariable("isbn") isbn : String, @RequestBody updateBookRequest : UpdateBookRequest) : ResponseEntity<Unit> {
        val book = Book(updateBookRequest.title, updateBookRequest.isRead, isbn)
        bookService.updateBook(book)
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build()
    }
}

