package com.team2.hrbank.changelog.service;

import com.team2.hrbank.changelog.dto.*;

import java.time.LocalDateTime;
import java.util.List;

public interface ChangeLogService {

    CursorPageResponseChangeLogDto getChangeLogs(ChangeLogRequestDto.PaginatedLogRequest request);

    List<DiffDto> getDiffByChangeLogId(Long id);

    Long getTotalCount(LocalDateTime fromDate, LocalDateTime toDate);

    ChangeLogDto save(EmployeeLogDto.CreateLogRequest request);

    ChangeLogDto save(EmployeeLogDto.CreateUpdateLogRequest request);

    ChangeLogDto save(EmployeeLogDto.CreateDeleteLogRequest request);

}
