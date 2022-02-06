package com.example.demoBDDCucumber.controller;

import com.example.demoBDDCucumber.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class BookController {

    @PostMapping("book")
    public String create(@RequestBody Book book) {
        log.info("Inside create {}", book);
        return "CREATED";
    }

    @GetMapping("book/{id}")
    public String get(@PathVariable String id) {
        log.info("Inside id {}", id);
        return "OK";
    }
}
