package com.juaracoding.pcmspringboot31.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juaracoding.pcmspringboot31.dto.validation.RegisDTO;
import com.juaracoding.pcmspringboot31.model.User;
import com.juaracoding.pcmspringboot31.security.JwtFilter;
import com.juaracoding.pcmspringboot31.security.JwtUtility;
import com.juaracoding.pcmspringboot31.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(AuthController.class)
class MockAuthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthService authService;

    @MockBean
    private JwtUtility jwtUtility;

    @MockBean
    private JwtFilter jwtFilter;

    @Test
    void testRegisSuccess() throws Exception {

        RegisDTO dto = new RegisDTO();
        dto.setNamaLengkap("Hakim Ari Andhika");
        dto.setEmail("hakimariandhika@gmail.com");
        dto.setPassword("Hakim@123");
        dto.setUsername("hakim.123");
        dto.setNoHp("+62896301571280");
        dto.setTanggalLahir(LocalDate.of(1999,5,12));

        User user = new User();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Registrasi berhasil");

        when(authService.mapToEntity(any(RegisDTO.class)))
                .thenReturn(user);
        when(authService.regis(any(User.class), any(HttpServletRequest.class)))
                .thenReturn(ResponseEntity.ok(response));

        mockMvc.perform(post("/api/auth/regis")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Registrasi berhasil"));
    }
}