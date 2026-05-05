package com.juaracoding.pcmspringboot31.controller;

import com.juaracoding.pcmspringboot31.dto.validation.ValAksesDTO;
import com.juaracoding.pcmspringboot31.dto.validation.ValMenuDTO;
import com.juaracoding.pcmspringboot31.service.MenuService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping("/v1")
    public ResponseEntity<Object> save(@Valid @RequestBody ValMenuDTO valMenuDTO, HttpServletRequest request) {
        return menuService.save(menuService.mapToEntity(valMenuDTO),request);
    }
}
