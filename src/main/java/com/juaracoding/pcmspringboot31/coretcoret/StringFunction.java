package com.juaracoding.pcmspringboot31.coretcoret;

public class StringFunction {


    public Integer lengthStr(String str){
        return str.toCharArray().length;
    }

    public String subStr(String str,Integer cut){
        return str.substring(cut);
    }
}
