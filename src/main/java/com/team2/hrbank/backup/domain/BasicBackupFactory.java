package com.team2.hrbank.backup.domain;

import lombok.Builder;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

public class BasicBackupFactory implements BackupFactory {

    @Override
    @Builder
    public Backup newBackup(
            String worker,
            LocalDateTime startedAt,
            LocalDateTime endedAt,
            BackupStatus status,
            @Nullable Long fileId
    ) {
        return new Backup(
                null,
                worker,
                startedAt,
                endedAt,
                status,
                null
        );
    }
}
