package com.juaracoding.pcmspringboot31.coretan;


import com.juaracoding.pcmspringboot31.coretcoret.Aritmatika;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

public class TestAritmatika {

    private Random random;
    private Aritmatika  aritmatika;

    @BeforeSuite
    public void initSuite(){

    }
    @BeforeClass
    public void init(){
        random = new Random();
        aritmatika = new Aritmatika();
    }

    @Test(priority=0)
    public void tambah(){
        Double output = aritmatika.tambah(2.0,3.0);
        Assert.assertEquals(output,5.0);
    }
    @Test(priority=5)
    public void kurang(){
        Double output = aritmatika.kurang(2.0,3.0);
        Assert.assertEquals(output,-1.0);
    }
    @Test(priority=10)
    public void bagi(){
        Double output = aritmatika.bagi(9.0,3.0);
        Assert.assertEquals(output,3.0);
    }
    @Test(priority=15)
    public void kali(){
        Double output = aritmatika.kali(2.0,3.0);
        Assert.assertEquals(output,6.0);
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class TestAritmatika");
    }
}