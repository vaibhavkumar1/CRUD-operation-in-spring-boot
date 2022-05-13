package com.springBoot.springboot.tutorial.service;

import com.springBoot.springboot.tutorial.entity.Department;
import com.springBoot.springboot.tutorial.error.DepartmentNotFoundException;
import com.springBoot.springboot.tutorial.resource.DepartmentDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DepartmentService {

    Department saveDepartment(Department department);

    Page<Department> fetchDepartmentList(int pageNumber, int pageSize);

    Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id) throws DepartmentNotFoundException;

    Department updateDepartmentById(Long id, Department department) ;

    Department fetchDepartmentByName(String name);
}
