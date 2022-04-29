package com.springBoot.springboot.tutorial.service;

import com.springBoot.springboot.tutorial.entity.Department;
import com.springBoot.springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository repository;

    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentName("IT")
                .departmentAddress("NewDelhi")
                .departmentCode("IT-09")
                .departmentId(1L)
                .build();

        Mockito.when(repository.findByDepartmentName("IT")).thenReturn(department);
    }

    @Test
    @DisplayName("Get data based on department name")
    @Disabled
    public void whenValidDepartmentName_ThenDepartmentShouldFound(){
        String departmentName="IT";
        Department found=departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }
}