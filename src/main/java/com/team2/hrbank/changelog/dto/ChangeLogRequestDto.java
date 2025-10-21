package com.team2.hrbank.changelog.dto;

import com.team2.hrbank.changelog.domain.LogType;

import java.time.LocalDateTime;

public class ChangeLogRequestDto {

    public record PaginatedLogRequest(
            String employeeNumber,
            LogType type,
            String memo,
            String ipAddress,
            LocalDateTime atFrom,
            LocalDateTime atTo,
            Long idAfter,
            String cursor,
            Integer size,
            String sortField,
            String sortDirection
    ) {
    }



}
