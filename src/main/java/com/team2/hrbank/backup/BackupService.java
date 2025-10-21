package com.team2.hrbank.backup;

import java.time.LocalDateTime;
import java.util.List;

public interface BackupService {

    BackupDto backup(BackupDto backupDto);

    // 전체 목록 조회 (정렬은 startAt, endedAt 조건 중 한 가지)
    List<BackupDto> getBackup();

    // 조건 조회
    List<BackupDto> getBackupByWorker(String worker);
    List<BackupDto> getBackupByStartedAt(LocalDateTime startedAt);
    List<BackupDto> getBackupByStatus(BackupStatus status);

    // 최근 백업 정보 조회
    BackupDto getRecentBackup();
}