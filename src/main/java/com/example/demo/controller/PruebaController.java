package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @GetMapping
    public String getMethodName() {
        return "Funciono por fucking vez";
    }
    

}
