package com.juaracoding.pcmspringboot31.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    // localhost:8080/api/auth/hore
    @GetMapping("/hore")
    public void hore(){

    }

    // localhost:8080/api/auth/yuhu
    @GetMapping("/yuhu")
    public void yuhu(){

    }



}
