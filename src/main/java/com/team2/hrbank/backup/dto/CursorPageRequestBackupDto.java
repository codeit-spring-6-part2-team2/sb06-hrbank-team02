package com.team2.hrbank.backup.dto;

import com.team2.hrbank.backup.domain.BackupStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CursorPageRequestBackupDto(
        String cursor,
        Long idAfter,
        String worker,
        LocalDateTime startedAtFrom,
        LocalDateTime startedAtTo,
        BackupStatus status,
        String sortBy,
        String order
) {
}
