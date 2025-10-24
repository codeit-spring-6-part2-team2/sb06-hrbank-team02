package com.team2.hrbank.backup.dto;

import com.team2.hrbank.backup.domain.BackupStatus;

import java.time.LocalDateTime;

public record CursorPageRequestBackupDto(
        String cursor,
        Long idAfter,
        String worker,
        LocalDateTime startedAt,
        BackupStatus status,
        String sortBy,
        String order
) {
}
