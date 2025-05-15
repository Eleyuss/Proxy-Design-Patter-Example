package com.gbv.appz1_hbv_l6.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gbv.appz1_hbv_l6.entity.Department;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Collections;
import java.util.List;

@Service
public class BackupDepartmentService {

    private static final String BACKUP_FILE_PATH = "H:\\programming\\WebJava\\WebApp_GBV_L3\\src\\departments.json";

    public static List<Department> getBackupDepartments() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File backupFile = new File(BACKUP_FILE_PATH);
            if (backupFile.exists()) {
                return mapper.readValue(backupFile, new TypeReference<List<Department>>() {});
            } else {
                System.err.println("Backup file not found.");
                return Collections.emptyList();
            }
        } catch (Exception e) {
            System.err.println("Error reading backup file: " + e.getMessage());
            return Collections.emptyList();
        }
    }
}