package com.team2.hrbank.changelog.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class EmployeeLogDto {

    private EmployeeLogDto() {
    }

    @Builder
    public record CreateLogRequest(
            LocalDateTime hireDate,
            String name,
            String position,
            String department,
            String email,
            String employeeNumber,
            String status,
            //ChangeLog의 필드
            String memo,
            String ipAddress
    ) {}

    @Builder
    public record CreateBeforeLogRequest(
            LocalDateTime hireDate,
            String name,
            String position,
            String department,
            String email,
            String employeeNumber,
            String status
    ) {}

    @Builder
    public record CreateDeleteLogRequest(
            LocalDateTime hireDate,
            String name,
            String position,
            String department,
            String email,
            String employeeNumber,
            String status,
            String memo,
            String ipAddress
    ) {}

}
