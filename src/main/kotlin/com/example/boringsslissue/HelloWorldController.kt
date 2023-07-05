package com.example.boringsslissue

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import io.netty.handler.ssl.SslContext

@RestController
@RequestMapping("/hello")
class HelloWorldController {

    init {
        SslContext.defaultClientProvider()
    }

    @GetMapping
    fun hello(): String {
        return "hello world!";
    }
}