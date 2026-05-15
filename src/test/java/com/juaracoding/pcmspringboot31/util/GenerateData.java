package com.juaracoding.pcmspringboot31.util;

import java.time.LocalDate;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateData {
    char [] chLowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    char [] chUpperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    char [] chAlfaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    char [] chAlfabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    char [] chValidSymbol = "@_#-$".toCharArray();
    String strProvider [] = {"gmail","yahoo","ymail","rocketmail","apamail","cumimail","ismail","guritamil"};
    String strDomain [] = {"com","co.id","id","xyz","jp","sg"};

    Random random = new Random();

    public String getSymbol(){
        return String.valueOf(chValidSymbol[random.nextInt(chValidSymbol.length)]);
    }

    public String generateEmail(){
        StringBuilder sBuild = new StringBuilder().append(genDataLowerCase(5,30)).
                append(".").append(random.nextInt(1000)).
                append("@").append(strProvider[random.nextInt(strProvider.length)]).append(".").
                append(strDomain[random.nextInt(strDomain.length)]);
        return sBuild.toString();
    }
    public String generateEmail(String namaLengkap){
        StringBuilder sBuild = new StringBuilder().append(namaLengkap.substring(0,namaLengkap.length()-1).toLowerCase().trim()).
                append(".").append(random.nextInt(1000)).
                append("@").append(strProvider[random.nextInt(strProvider.length)]).append(".").
                append(strDomain[random.nextInt(strDomain.length)]);
        return sBuild.toString();
    }

    public String genDataLowerCase(int start, int end){
        Integer lengthOfData = random.nextInt(start,end);
        StringBuilder sBuild = new StringBuilder();
        sBuild.setLength(0);
        for(int i = 0; i <= lengthOfData; i++){
            sBuild.append(chLowerCase[random.nextInt(26)]);
        }
        return sBuild.toString();
    }

    public String genDataUpperCase(int start, int end){
        StringBuilder sBuild = new StringBuilder();
        Integer lengthOfData = random.nextInt(start,end);
        sBuild.setLength(0);
        for(int i = 0; i <= lengthOfData; i++){
            sBuild.append(chUpperCase[random.nextInt(26)]);
        }
        return sBuild.toString();
    }

    public String genDataAlfabet(int start, int end){
        StringBuilder sBuild = new StringBuilder();
        try{

            Integer lengthOfData = random.nextInt(start,end);
            sBuild.setLength(0);
            /** seharusnya i =0 , bukan i=start */
            for(int i = 0; i <= lengthOfData; i++){
                sBuild.append(chAlfabet[random.nextInt(52)]);
            }
        }catch (Exception e){
            System.out.println("Error Generate Data : "+e.getMessage());
        }
        return sBuild.toString();
    }

    public String genDataAlfaNumeric(int start, int end){
        StringBuilder sBuild = new StringBuilder();
        Integer lengthOfData = random.nextInt(start,end);
        sBuild.setLength(0);
        for(int i = 0; i <= lengthOfData; i++){
            sBuild.append(chAlfaNumeric[random.nextInt(62)]);
        }
        return sBuild.toString();
    }

    /**
     * Menggenerate tanggal acak dan mengembalikannya dalam format yyyy-MM-dd
     */
    public String generateTanggalLahir() {

        LocalDate end = LocalDate.now();
        LocalDate start = end.minusYears(random.nextInt(1000));
        long startEpoch = start.toEpochDay();
        long endEpoch = end.toEpochDay();

        long randomEpoch = ThreadLocalRandom.current().nextLong(startEpoch, endEpoch);

        // LocalDate secara default menggunakan format yyyy-MM-dd saat dipanggil toString()
        return LocalDate.ofEpochDay(randomEpoch).toString();
    }
    public LocalDate generateTanggalLahir(String isNull) {

        LocalDate end = LocalDate.now();
        LocalDate start = end.minusYears(random.nextInt(1000));
        long startEpoch = start.toEpochDay();
        long endEpoch = end.toEpochDay();

        long randomEpoch = ThreadLocalRandom.current().nextLong(startEpoch, endEpoch);

        // LocalDate secara default menggunakan format yyyy-MM-dd saat dipanggil toString()
        return LocalDate.ofEpochDay(randomEpoch);
    }

    public Integer randomInt(int max){
        return random.nextInt(max);
    }
    public Integer randomInt(int min, int max){
        return random.nextInt(min,max);
    }
}