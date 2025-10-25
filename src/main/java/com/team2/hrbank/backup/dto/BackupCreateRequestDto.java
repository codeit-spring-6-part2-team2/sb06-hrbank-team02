package com.team2.hrbank.backup.dto;

import com.team2.hrbank.backup.domain.BackupStatus;

import java.time.LocalDateTime;

public record BackupCreateRequestDto(
        String worker
) {
}
