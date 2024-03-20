package com.example.interceptormiddleware2.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class BasicController {

    @GetMapping
    public ResponseEntity<String> getCurrentDateTime() {
        return ResponseEntity.ok().body("welcome");
    }

}
