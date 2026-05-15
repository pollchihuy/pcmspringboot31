package com.juaracoding.pcmspringboot31.controller;


import com.juaracoding.pcmspringboot31.util.GenerateData;
import org.json.simple.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestMenuController extends AbstractTestNGSpringContextTests {

    public JSONObject requestBody;
    //1x request regis under 500ms / 0.5s throughput
    @BeforeClass
    public void initClass(){
        if(TestAuthController.jwt.equals("")){
            TestAuthController.jwt = "admin";
        }
        if(TestAuthController.generateData==null){
            TestAuthController.generateData = new GenerateData();
        }
    }

}