package com.team2.hrbank.employee.domain;

import lombok.Builder;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;

public class BasicEmployeeFactory implements EmployeeFactory {

    @Override
    @Builder
    public Employee newEmployee(
            String name,
            EmployeeEmail email,
            EmployeeNumber employeeNumber,
            Long departmentId,
            String position,
            LocalDate hireDate,
            EmployeeStatus status,
            @Nullable Long profileImageId
    ) {
        return new Employee(
                null,
                name,
                email,
                employeeNumber,
                departmentId,
                position,
                hireDate,
                EmployeeStatus.ACTIVE,
                profileImageId
        );
    }
}
