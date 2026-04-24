package com.juaracoding.pcmspringboot31.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/coba")
public class CobaController {


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
