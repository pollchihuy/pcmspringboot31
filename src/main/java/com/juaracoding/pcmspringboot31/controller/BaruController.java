package com.juaracoding.pcmspringboot31.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/baru")
public class BaruController {

    @PreAuthorize("hasAuthority('4p')")
    public void downloadExcel(){

    }

    @PreAuthorize("hasAuthority('4p')")
    public void downloadPdf(){

    }
    @PreAuthorize("hasAuthority('4v')")
    public void findAll(){

    }
    @PreAuthorize("hasAuthority('4v')")
    public void search(){

    }

}
