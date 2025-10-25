package com.team2.hrbank.backup.domain;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Backup {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Nullable
    private Long id;

    private String worker;
    private LocalDateTime startedAt;

    @Nullable
    private LocalDateTime endedAt;

    @Enumerated(EnumType.STRING)
    private BackupStatus status;

    @Nullable
    private Long fileId;

    public Backup withCompleted(LocalDateTime endedAt, Long fileId) {
        return this.toBuilder()
                .endedAt(endedAt)
                .fileId(fileId)
                .status(BackupStatus.COMPLETED)
                .build();
    }

    public Backup withFailed(LocalDateTime endedAt, Long fileId) {
        return this.toBuilder()
                .endedAt(endedAt)
                .fileId(fileId)
                .status(BackupStatus.FAILED)
                .build();
    }

    public Backup withSkipped(LocalDateTime endedAt) {
        return this.toBuilder()
                .endedAt(endedAt)
                .status(BackupStatus.SKIPPED)
                .build();
    }
}