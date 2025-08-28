package com.example.chatbuddy;

import org.springframework.web.bind.annotation.*;

@RestController
public class ChatController {

    @GetMapping("/")
    public String getRoot() {
        return "Hello world";
    }

    @GetMapping("/greet")
    public String getGreet(@RequestParam String name) {
        return "Hello " + name + "!";
    }
}