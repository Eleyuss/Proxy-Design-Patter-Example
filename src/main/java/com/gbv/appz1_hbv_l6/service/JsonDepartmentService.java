package com.gbv.appz1_hbv_l6.service;

import com.gbv.appz1_hbv_l6.entity.Department;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JsonDepartmentService implements DepartmentService {

    private List<Department> departments;

    public JsonDepartmentService() {
        // Инициализация данными из JSON (или другого источника)
        departments = new ArrayList<>();
    }

    @Override
    public List<Department> getAllDepartments() {
        return departments; // Возврат данных из памяти
    }

    @Override
    public Department getById(Long id) {
        return departments.stream()
                .filter(department -> department.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String insertDepartment(Department department) {
        throw new UnsupportedOperationException("Добавление не поддерживается в резервных данных.");
    }

    @Override
    public String updateDepartment(Department department) {
        throw new UnsupportedOperationException("Обновление не поддерживается в резервных данных.");
    }

    @Override
    public boolean hasWorkers(long departmentId) {
        return false;
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Удаление не поддерживается в резервных данных.");
    }
}
