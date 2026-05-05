package com.juaracoding.pcmspringboot31.controller;

import com.juaracoding.pcmspringboot31.dto.query.SearchAksesDTO;
import com.juaracoding.pcmspringboot31.dto.validation.ValAksesDTO;
import com.juaracoding.pcmspringboot31.service.AksesService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/akses")
public class AksesController {

    @Autowired
    private AksesService aksesService;

    @PostMapping("/v1")
    public ResponseEntity<Object> save(@Valid @RequestBody ValAksesDTO valAksesDTO, HttpServletRequest request) {
        return aksesService.save(aksesService.mapToEntity(valAksesDTO),request);
    }
}
