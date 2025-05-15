package com.gbv.appz1_hbv_l6.service;

import com.gbv.appz1_hbv_l6.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProxyDepartmentService implements DepartmentService {

    private final DepartmentServiceImpl dbService;
    private final JsonDepartmentService jsonService;

    @Autowired
    public ProxyDepartmentService(DepartmentServiceImpl dbService, JsonDepartmentService jsonService) {
        this.dbService = dbService;
        this.jsonService = jsonService;
    }

    @Override
    public List<Department> getAllDepartments() {
        try {
            return dbService.getAllDepartments(); // Попытка получить данные из БД
        } catch (Exception e) {
            System.err.println("База данных недоступна: " + e.getMessage());
            return jsonService.getAllDepartments(); // Переключение на резерв
        }
    }

    @Override
    public Department getById(Long id) {
        try {
            return dbService.getById(id); // Попытка получить данные из БД
        } catch (Exception e) {
            System.err.println("Ошибка получения отдела по ID: " + e.getMessage());
            return jsonService.getById(id); // Переключение на резерв
        }
    }

    @Override
    public String insertDepartment(Department department) {
        try {
            return dbService.insertDepartment(department); // Попытка добавить в БД
        } catch (Exception e) {
            System.err.println("Ошибка добавления отдела в БД: " + e.getMessage());
            return "Ошибка: добавление невозможно, резервный источник поддерживает только чтение.";
        }
    }

    @Override
    public String updateDepartment(Department department) {
        try {
            return dbService.updateDepartment(department); // Попытка обновить в БД
        } catch (Exception e) {
            System.err.println("Ошибка обновления отдела в БД: " + e.getMessage());
            return "Ошибка: обновление невозможно, резервный источник поддерживает только чтение.";
        }
    }

    @Override
    public boolean hasWorkers(long departmentId) {
        return false;
    }

    @Override
    public void deleteById(Long id) {
        try {
             dbService.deleteById(id); // Попытка удалить из БД
        } catch (Exception e) {
            System.err.println("Ошибка удаления отдела из БД: " + e.getMessage());
        }
    }
}
