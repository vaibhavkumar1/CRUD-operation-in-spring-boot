package com.springBoot.springboot.tutorial.service;

import com.springBoot.springboot.tutorial.entity.Department;
import com.springBoot.springboot.tutorial.error.DepartmentNotFoundException;
import com.springBoot.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository repository;
    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public Page<Department> fetchDepartmentList(int pageNumber, int pageSize) {
        Pageable firstPage= PageRequest.of(pageNumber,pageSize);
        Page<Department> page=repository.findAll(firstPage);
        return page;
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department= repository.findById(id);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Not Available");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long id) throws DepartmentNotFoundException {
        Optional<Department> department= repository.findById(id);
        if (!department.isPresent()){
            throw new DepartmentNotFoundException("Department Is Not Available of This Id");
        }
        repository.deleteById(id);
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department depDB=repository.findById(id).get();
        if(Objects.nonNull(department.getDepartmentName()) && !"".equals(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equals(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        if(Objects.nonNull(department.getDepartmentCode()) && !"".equals(department.getDepartmentCode())){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }
        return repository.save(depDB);
    }

    @Override
    public Department fetchDepartmentByName(String name) {
        return repository.findByDepartmentName(name);
    }
}
