package com.springBoot.springboot.tutorial.controller;

import com.springBoot.springboot.tutorial.entity.Department;
import com.springBoot.springboot.tutorial.error.DepartmentNotFoundException;
import com.springBoot.springboot.tutorial.resource.DepartmentDto;
import com.springBoot.springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;


    private final Logger logger=LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody DepartmentDto department){
        logger.info("Inside saveDepartment of DepartmentController");
        Department department1=new Department();
        department1.setDepartmentCode(department.getDepartmentCode());
        department1.setDepartmentName(department.getDepartmentName());
        department1.setDepartmentAddress(department.getDepartmentAddress());

        return departmentService.saveDepartment(department1);
    }

    @GetMapping("/departments")
    public Page<Department> fetchDepartmentList(
            @RequestParam("pageNumber") int pageNumber,
            @RequestParam("pageSize") int pageSize
            ){
        return departmentService.fetchDepartmentList(pageNumber,pageSize);
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        departmentService.deleteDepartmentById(id);
        return "Department deleted successfully...";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long id,@RequestBody Department department){
        return departmentService.updateDepartmentById(id,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name){
        return departmentService.fetchDepartmentByName(name);
    }
}
