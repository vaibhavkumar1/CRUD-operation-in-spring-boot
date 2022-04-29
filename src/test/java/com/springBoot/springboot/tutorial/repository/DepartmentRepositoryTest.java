package com.springBoot.springboot.tutorial.repository;

import com.springBoot.springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department=Department.builder()
                .departmentName("IT")
                .departmentAddress("NewDelhi")
                .departmentCode("IT-09")
                .build();

        entityManager.persist(department);
    }

    @Test
    @DisplayName("Get data based on department name")
    public void whenValidDepartmentName_ThenDepartmentShouldFound(){
        String departmentName="IT";
        Department found=repository.findByDepartmentName(departmentName);

        assertEquals(departmentName,found.getDepartmentName());
    }

}