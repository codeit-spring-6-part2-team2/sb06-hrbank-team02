package com.team2.hrbank.employee.domain;

import org.jspecify.annotations.Nullable;

import java.time.LocalDate;

public interface EmployeeFactory {

    Employee newEmployee(
            String name,
            EmployeeEmail email,
            EmployeeNumber employeeNumber,
            Long departmentId,
            String position,
            LocalDate hireDate,
            EmployeeStatus status,
            @Nullable Long profileImageId
    );
}
