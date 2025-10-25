package com.team2.hrbank.backup.dto;

import java.util.List;

public record CursorPageResponseBackupDto(
        List<BackupDto> content,
        String nextCursor,
        Long nextIdAfter,
        Integer size,
        Long totalElements,
        Boolean hasNext
) {
}
