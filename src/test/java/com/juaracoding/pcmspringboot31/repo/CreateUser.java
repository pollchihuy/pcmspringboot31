package com.juaracoding.pcmspringboot31.repo;

import com.juaracoding.pcmspringboot31.model.Akses;
import com.juaracoding.pcmspringboot31.model.User;
import com.juaracoding.pcmspringboot31.util.GenerateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CreateUser extends AbstractTestNGSpringContextTests {
    @Autowired
    UserRepo userRepo;

    private GenerateData generateData;
    @BeforeTest
    public void init(){
        generateData = new GenerateData();
    }
    @Test
    public void bikinData(){
        Akses akses = new Akses();
        akses.setId(2L);
        String currentUser = "{\"id\":\"1\",\"nama\":\"System\"}";
        for (int i = 0; i < 10; i++) {
            User user = new User();
            String namaLengkap = generateData.genDataAlfabet(4,75);
            String email = generateData.generateEmail(namaLengkap);
            String username = generateData.genDataLowerCase(6,12)+"."+generateData.randomInt(999);
            String password = generateData.genDataAlfabet(6,11)+generateData.getSymbol()+generateData.randomInt(999);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setNoHp("08"+generateData.randomInt(100000000,999999999));
            user.setNamaLengkap(namaLengkap);
            user.setTanggalLahir(generateData.generateTanggalLahir(null));
            user.setAkses(akses);
            user.setCreatedBy(currentUser);
            userRepo.save(user);
        }
    }
}
