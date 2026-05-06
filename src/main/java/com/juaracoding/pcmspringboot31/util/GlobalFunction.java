package com.juaracoding.pcmspringboot31.util;

public class GlobalFunction {

    /** filter pencarian untuk string */
    public static Boolean checkFilter(String s){
        return s!=null && !s.isEmpty() && !s.isBlank() && regexText(s);
    }
    public static Boolean checkFilter(Object o){
        return o!=null;
    }
    /** hanya mengijinkan pencarian alfanumerik titik koma dan spasi yang umum saja */
    public static Boolean regexText(String o){
        return o.matches("^[\\w\\.,\\s]{1,}$");
    }
}
