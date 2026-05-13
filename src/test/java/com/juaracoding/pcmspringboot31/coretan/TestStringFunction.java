package com.juaracoding.pcmspringboot31.coretan;

import com.juaracoding.pcmspringboot31.coretcoret.StringFunction;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestStringFunction {

    private StringFunction stringFunction ;

    @BeforeClass
    public void init(){
        stringFunction = new StringFunction();
    }
    @Test(priority=0)
    public void lengthStr(){
        Integer strOutput =  stringFunction.lengthStr("welcome");
        Assert.assertEquals(strOutput,7);
    }

    @Test(priority=5)
    public void subStr(){
        String strOutput =  stringFunction.subStr("welcome",3);
        Assert.assertEquals(strOutput,"come");
    }

    @AfterClass
    public void endClass(){
        System.out.println("Testing class TestStringFunction Selesai ");
    }

    @AfterSuite
    public void afterSuitez(){
        System.out.println("Testing selesai semua !!");
    }
}
