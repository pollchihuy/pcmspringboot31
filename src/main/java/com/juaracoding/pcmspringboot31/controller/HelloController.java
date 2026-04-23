package com.juaracoding.pcmspringboot31.controller;

import com.juaracoding.pcmspringboot31.config.GuritaConfig;
import com.juaracoding.pcmspringboot31.dto.validation.LoginDTO;
import com.juaracoding.pcmspringboot31.service.UserServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("api/hello")
public class HelloController {

    @Autowired
    private LoginDTO loginDTO;//IOC Inversion Of Control

    @Autowired
    private UserServices userServices;

    @Autowired
    private Random random ;

    @Value("${cumi.api.base-url}")
    private String baseUrl;

    @Autowired
    GuritaConfig guritaConfig;

    @GetMapping("/welcome")
    public String welcome() {
        return "hello";
//        return new LoginDTO();
    }

    @GetMapping("/di")
    public Object dependencyInjection() {
        loginDTO.setUsername("paul123");
        loginDTO.setPassword("Paul@1234");
        System.out.println("Random number: " + random.nextInt(100));
        System.out.println("Base Url : " + baseUrl);
        System.out.println("Gurita Config Name : " + guritaConfig.getName());
        System.out.println("Gurita Config Price : " + guritaConfig.getPrice());
        return loginDTO;
    }

    //localhost:8080/api/hello
    @PostMapping
    public Object postData(@RequestBody LoginDTO loginDTO
                           , HttpServletRequest request
                           ,HttpServletResponse response) {
        System.out.println("Masuk Kesini");
        loginDTO.setUsername(loginDTO.getUsername()+" : DTO");
        loginDTO.setPassword(loginDTO.getPassword()+" : DTO");
        response.addHeader("X-SRF", "o1i283u19823y1pjpo1ji23iop4jp");
        return loginDTO;
    }
    //SSRF Server Side Request Forgery

    //localhost:8080/api/hello ----- api/hello adalah path , localhost:8080 adalah baseUrl
    @GetMapping
    public Object getData() {
        return "Masuk Bray!!";
    }

    @PutMapping
    public Object putData() {
        return "Masuk Bray!!";
    }
}