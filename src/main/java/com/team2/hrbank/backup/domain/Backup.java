package com.team2.hrbank.backup.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Table
public class Backup {
    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String worker;

    @Getter
    @Column(nullable = false, updatable = false)
    private LocalDateTime startedAt;

    @Column(nullable = false)
    private LocalDateTime endedAt;

    @Getter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BackupStatus status;

    @Nullable
    @Column
    private Long fileId;

    protected Backup() {
    }

    protected Backup(
            @Nullable Long id,
            String worker,
            LocalDateTime startedAt,
            LocalDateTime endedAt,
            BackupStatus status,
            @Nullable Long fileId
    ) {
        this.id = id;
        this.worker = worker;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.status = status;
        this.fileId = fileId;
    }

    public Optional<Long> getId() {
        return Optional.ofNullable(id);
    }

    public Optional<Long> getFileId() {
        return Optional.ofNullable(fileId);
    }
}