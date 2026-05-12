package com.juaracoding.pcmspringboot31.controller;

import com.juaracoding.pcmspringboot31.core.SMTPCore;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/open")
public class OpenController {


    @GetMapping("/{mailto}")
    public String kirimEmail(@PathVariable String mailto){
        System.out.println("Start Thread "+Thread.currentThread().getName());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Email Thread "+Thread.currentThread().getName());
                new SMTPCore().sendMailWithAttachment(new String[]{mailto},
                        "OTP Registrasi",
                        contentHtml("Paul Christian","Registrasi","123456"),
                        "TLS",null);
            }
        }).start();

        return "OK";
    }

    public String contentHtml(String namaLengkap,String activity,String otp){
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