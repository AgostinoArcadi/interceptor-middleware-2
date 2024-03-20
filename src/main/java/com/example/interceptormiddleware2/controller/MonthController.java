package com.example.interceptormiddleware2.controller;

import com.example.interceptormiddleware2.entity.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/months")
public class MonthController {

    @GetMapping
    public Month get(HttpServletRequest request) {
        return (Month) request.getAttribute("month");
    }
}
