package com.team2.hrbank.backup.dto;

import com.team2.hrbank.backup.domain.BackupStatus;

import java.time.LocalDateTime;

public record BackupDto(
        Long id,
        String worker,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        BackupStatus status,
        Long fileId
) {
}
