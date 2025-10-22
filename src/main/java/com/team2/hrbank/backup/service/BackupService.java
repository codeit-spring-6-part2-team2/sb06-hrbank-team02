package com.team2.hrbank.backup.service;

import com.team2.hrbank.backup.domain.BackupStatus;
import com.team2.hrbank.backup.dto.BackupDto;

import java.time.LocalDateTime;
import java.util.List;

public interface BackupService {

    // 백업 생성
    BackupDto addBackup(BackupDto backupDto);

    // 전체 목록 조회 (정렬은 startedAt, endedAt 조건 중 하나)
    List<BackupDto> getBackup();
    // 조건 목록 조회
    List<BackupDto> getBackups(BackupDto backupDto);

    // 최근 백업 정보 조회
    BackupDto getRecentBackup();
}
