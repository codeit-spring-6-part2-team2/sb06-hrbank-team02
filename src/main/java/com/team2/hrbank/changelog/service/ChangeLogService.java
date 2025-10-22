package com.team2.hrbank.changelog.service;

import com.team2.hrbank.changelog.dto.ChangeLogDto;
import com.team2.hrbank.changelog.dto.ChangeLogRequestDto;
import com.team2.hrbank.changelog.dto.CursorPageResponseChangeLogDto;
import com.team2.hrbank.changelog.dto.DiffDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ChangeLogService {

    CursorPageResponseChangeLogDto<ChangeLogDto> getChangeLogs(ChangeLogRequestDto.PaginatedLogRequest request);

    List<DiffDto> getDiffByChangeLogId(Long id);

    Long getTotalCount(LocalDateTime fromDate, LocalDateTime toDate);

}
