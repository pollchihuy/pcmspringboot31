package com.juaracoding.pcmspringboot31.controller;

import com.juaracoding.pcmspringboot31.dto.CobaDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/full")
public class FullController {

    @PostMapping("/v1/pos")
    public String fullPost(@Valid @RequestBody CobaDTO cobaDTO) {
        System.out.println("ID : " + cobaDTO.getId());
        System.out.println("Nama Lengkap : " + cobaDTO.getNamaLengkap());
        System.out.println("Price : " + cobaDTO.getPrice());
        System.out.println("Description  : " + cobaDTO.getDescription());
        return "Post Sukses";
    }


    //localhost:8080/api/full/v1/get/ver1/1
    @GetMapping("/v1/get/{coba_doank}/{id_user}")
    public String fullGet(
            @PathVariable(value ="id_user" ) Long id,
            @PathVariable(value ="coba_doank" ) String coba
    ) {
        System.out.println("ID User : " + id);
        System.out.println("Coba Doank : " + coba);
        return "Get Sukses";

    }

    //localhost:8080/api/full/v1/get?id=4&coba_doank=paul
    @GetMapping("/v1/get")
    public String fullGetQueryParam(
            @RequestParam Long id,
            @RequestParam(value ="coba_doank" ) String coba
    ) {
        System.out.println("ID User : " + id);
        System.out.println("Coba Doank : " + coba);
        return "Get Sukses";

    }

    //localhost:8080/api/full/v1/get?id=4&coba_doank=paul
    @GetMapping("/v1/multi_part")
    public String fullSingleMultipart(
            @RequestParam Long id,
            @RequestParam(value ="coba_doank" ) String coba, //- -> Hyphen
            @RequestParam String value,
            @RequestParam MultipartFile file
    ) {
        System.out.println("ID User : " + id);
        System.out.println("Coba Doank : " + coba);
        System.out.println("Value : " + value);
        System.out.println("File : " + file.getOriginalFilename());
        return "Get MultiPart Sukses ";
    }

    //localhost:8080/api/full/v1/multi_multi_part
    @GetMapping("/v1/multi_multi_part")
    public String fullMultiMultipart(
            @RequestParam String [] cost,
            @RequestParam("keterangan_foto") String [] keteranganFoto,
            @RequestParam BigDecimal [] nominal,
            @RequestParam MultipartFile [] file
    ) {
        for (int i = 0; i < cost.length; i++) {
            System.out.println("Cost : " + cost[i]);
            System.out.println("Keterangan Foto : " + keteranganFoto[i]);
            System.out.println("Nominal : " + nominal[i]);
            System.out.println("File : " + file[i].getOriginalFilename());
        }
        return "Get MultiPart Sukses ";
    }
}
