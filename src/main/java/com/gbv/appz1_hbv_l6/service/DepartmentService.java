package com.gbv.appz1_hbv_l6.service;

import com.gbv.appz1_hbv_l6.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    String insertDepartment(Department department);
    String updateDepartment(Department department);
    boolean hasWorkers(long departmentId);
    Department getById(Long id);
    void deleteById(Long id);
}
