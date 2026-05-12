package com.juaracoding.pcmspringboot31.util;

public class EmailTemplate {

    public static String sentOtp(String namaLengkap,String activity,String otp){
        String htmlTemplate = """
            <html>
            <body style="font-family: Arial, sans-serif; line-height: 1.6;">
                <p><i>dear %s,</i></p>
                
                <p>Bersama dengan email ini, kami memberitahukan otp untuk %s, yaitu:</p>
                
                <h1 style="color: #00008B; font-weight: bold;">%s</h1>
                
                <p>terima kasih,</p>
                
                <br>
                <p style="color: #555555; font-size: 12px;">
                    Notes : mohon untuk tidak membalas email ini karena dikirimkan otomatis oleh sistem.
                </p>
            </body>
            </html>
            """;
        return String.format(htmlTemplate, namaLengkap, activity, otp);
    }
}
