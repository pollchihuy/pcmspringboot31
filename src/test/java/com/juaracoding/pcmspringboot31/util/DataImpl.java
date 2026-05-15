package com.juaracoding.pcmspringboot31.util;

public class DataImpl {
    public static void main(String[] args) {
        GenerateData generateData = new GenerateData();
        for (int i = 0; i < 100; i++) {
            System.out.println(generateData.generateEmail());
        }
    }
}