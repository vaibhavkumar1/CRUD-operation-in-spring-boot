package com.springBoot.springboot.tutorial.controller;

import com.springBoot.springboot.tutorial.entity.Department;
import com.springBoot.springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.RequestEntity.post;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService service;

    private Department department;

    @BeforeEach
    void setUp() {
        department=Department.builder()
                .departmentName("IT")
                .departmentAddress("NewDelhi")
                .departmentCode("IT-09")
                .departmentId(1L)
                .build();
    }

    public void saveDepartment(){
        Department inputDepartment=Department.builder()
                .departmentName("IT")
                .departmentAddress("NewDelhi")
                .departmentCode("IT-09")
                .departmentId(1L)
                .build();

//        Mockito.when(service.saveDepartment(inputDepartment)).thenReturn(department);

//        mockMvc.perform(post("/departments")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content())
//                .andExpect(MockMvcResultMatchers
//                        .status()
//                        .isOk());
    }

}