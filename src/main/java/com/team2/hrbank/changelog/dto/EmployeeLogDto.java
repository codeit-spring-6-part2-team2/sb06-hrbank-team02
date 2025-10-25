package com.team2.hrbank.changelog.dto;

import lombok.Builder;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

public class EmployeeLogDto {

    private EmployeeLogDto() {
    }

    @Builder
    public record CreateLogRequest(
            // Employee info
            LocalDateTime hireDate,
            String employeeName,
            String employeePosition,
            String departmentName,
            String employeeEmail,
            String employeeNumber,
            String employeeStatus,
            // metadata
            @Nullable String memo,
            String ipAddress
    ) {}

    @Builder
    public record CreateDeleteLogRequest(
            // Employee info
            String employeeNumber,
            // metadata
            @Nullable String memo,
            String ipAddress
    ) {}

}
