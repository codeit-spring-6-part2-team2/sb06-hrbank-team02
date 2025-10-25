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
            String name,
            String position,
            String department,
            String email,
            String employeeNumber,
            String status,
            boolean isDeleted,
            // metadata
            @Nullable String memo,
            String ipAddress
    ) {}

    @Builder
    public record CreateUpdateLogRequest(
            // Before Employee info
            LocalDateTime beforeHireDate,
            String beforeName,
            String beforePosition,
            String beforeDepartment,
            String beforeEmail,
            String beforeEmployeeNumber,
            String beforeStatus,
            boolean beforeIsDeleted,
            // After Employee info
            LocalDateTime afterHireDate,
            String afterName,
            String afterPosition,
            String afterDepartment,
            String afterEmail,
            String afterEmployeeNumber,
            String afterStatus,
            boolean afterIsDeleted,
            // metadata
            @Nullable String memo,
            String ipAddress
    ) {}

    @Builder
    public record CreateDeleteLogRequest(
            // Employee info
            LocalDateTime hireDate,
            String name,
            String position,
            String department,
            String email,
            String employeeNumber,
            String status,
            boolean isDeleted,
            // metadata
            @Nullable String memo,
            String ipAddress
    ) {}

}
