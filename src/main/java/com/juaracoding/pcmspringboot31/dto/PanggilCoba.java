package com.juaracoding.pcmspringboot31.dto;

public class PanggilCoba {

    public static void main(String[] args) {
        CobaDTO cobaDTO = new CobaDTO();
        cobaDTO.setId(1L);
        cobaDTO.setName("Contoh Nama");
        cobaDTO.setDescription("Deskripsi Contoh");
        cobaDTO.setPrice(99.99);

        System.out.println("ID: " + cobaDTO.getId());
        System.out.println("Name: " + cobaDTO.getName());
        System.out.println("Description: " + cobaDTO.getDescription());
        System.out.println("Price: " + cobaDTO.getPrice());
    }
}
