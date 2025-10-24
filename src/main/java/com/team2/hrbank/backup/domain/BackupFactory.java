package com.team2.hrbank.backup.domain;

import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

public interface BackupFactory {
    Backup newBackup(
        String worker,
        LocalDateTime startedAt,
        LocalDateTime endedAt,
        BackupStatus status,
        @Nullable Long fileId
    );
}
