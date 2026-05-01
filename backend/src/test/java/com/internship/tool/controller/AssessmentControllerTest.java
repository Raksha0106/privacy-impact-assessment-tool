package com.internship.tool.controller;

import com.internship.tool.entity.Assessment;
import com.internship.tool.security.JwtAuthFilter;
import com.internship.tool.security.JwtUtil;
import com.internship.tool.service.AssessmentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AssessmentController.class)
@AutoConfigureMockMvc(addFilters = false) // 🔥 IMPORTANT
public class AssessmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssessmentService service;

    @MockBean
    private JwtUtil jwtUtil;

    @MockBean
    private JwtAuthFilter jwtAuthFilter;

    @Test
    void testGetAll() throws Exception {

        when(service.getAllList())
                .thenReturn(Arrays.asList(new Assessment()));

        mockMvc.perform(get("/assessments/list")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}