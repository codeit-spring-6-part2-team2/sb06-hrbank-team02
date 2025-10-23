package com.team2.hrbank.changelog.service;

import com.team2.hrbank.changelog.dto.*;

import java.time.LocalDateTime;
import java.util.List;

public interface ChangeLogService {

    CursorPageResponseChangeLogDto getChangeLogs(ChangeLogRequestDto.PaginatedLogRequest request);

    List<DiffDto> getDiffByChangeLogId(Long id);

    Long getTotalCount(LocalDateTime fromDate, LocalDateTime toDate);

    ChangeLogDto addCreateEmployeeLog(EmployeeLogDto.CreateLogRequest request);

    ChangeLogDto addUpdateEmployeeLog(EmployeeLogDto.CreateUpdateLogRequest request);

    ChangeLogDto addDeleteEmployeeLog(EmployeeLogDto.CreateDeleteLogRequest request);

}
