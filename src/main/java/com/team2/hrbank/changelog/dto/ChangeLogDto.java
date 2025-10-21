package com.team2.hrbank.changelog.dto;

import com.team2.hrbank.changelog.domain.LogType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ChangeLogDto(
        Long id,
        LogType type,
        String employeeNumber,
        String memo,
        String ipAddress,
        LocalDateTime at
) {
}
