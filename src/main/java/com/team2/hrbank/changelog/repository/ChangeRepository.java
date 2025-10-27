package com.team2.hrbank.changelog.repository;

import com.team2.hrbank.changelog.dto.ChangeLogRequestDto;
import com.team2.hrbank.changelog.dto.CursorPageResponseChangeLogDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChangeRepository {

    public CursorPageResponseChangeLogDto findChangeLogs(ChangeLogRequestDto.PaginatedLogRequest request) {
        // Implementation placeholder
        return null;
    }

    public Long countChangeLogs() {
        // Implementation placeholder
        return 0L;
    }

}
