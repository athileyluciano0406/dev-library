package com.athiley.devlibrary.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorldController {
    @GetMapping("/about")
    fun returnHelloWorld(): String {
        return "Hello World, we are building this application"
    }
}
