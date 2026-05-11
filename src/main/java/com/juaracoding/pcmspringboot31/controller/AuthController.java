package com.juaracoding.pcmspringboot31.controller;

import com.juaracoding.pcmspringboot31.dto.validation.LoginDTO;
import com.juaracoding.pcmspringboot31.dto.validation.RegisDTO;
import com.juaracoding.pcmspringboot31.model.User;
import com.juaracoding.pcmspringboot31.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/auth")
public class AuthController {


    @Autowired
    private AuthService authService;

    @PostMapping("/regis")
    public ResponseEntity<Object> regis(@RequestBody RegisDTO regisDTO,
                                        HttpServletRequest request){
        return authService.regis(authService.mapToEntity(regisDTO),request);
    }



}
