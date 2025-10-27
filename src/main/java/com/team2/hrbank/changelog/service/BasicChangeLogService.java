package com.team2.hrbank.changelog.service;

import com.team2.hrbank.changelog.dto.*;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class BasicChangeLogService implements ChangeLogService{
    
    @Override
    public CursorPageResponseChangeLogDto getChangeLogs(ChangeLogRequestDto.PaginatedLogRequest request) {

        // return paginated logs from repository

        return null;
    }

    @Override
    public List<DiffDto> getDiffByChangeLogId(Long id) {

        // get ChangeLog and List of EmployeeLogDiff by ChangeLog id from repository

        // if size is 1 and ChangeLogType is DELETED return all fields as before

        // if size is 1 and ChangeLogType is CREATED return all fields as after

        // if size is 2 return only changed fields

        return List.of();
    }

    @Override
    public Long getTotalCount(LocalDateTime fromDate, LocalDateTime toDate) {

        // return count from repository

        return 0L;
    }

    @Override
    public LocalDateTime getRecentLogDate() {

        // return recent log date from repository

        return null;
    }

    @Transactional
    @Override
    public ChangeLogDto addEmployeeInsertLog(EmployeeLogDto.CreateLogRequest request) {

        // insert ChangeLog and return entity

        // insert EmployeeLog as after log

        // convert to ChangeLogDto and return

        return null;
    }

    @Transactional
    @Override
    public ChangeLogDto addEmployeeUpdateLog(EmployeeLogDto.CreateLogRequest request) {

        // get after Employee log of same employeeNumber

        // insert ChangeLog and return entity

        // insert EmployeeLog

        // convert to ChangeLogDto and return

        return null;
    }

    @Transactional
    @Override
    public ChangeLogDto addEmployeeDeleteLog(EmployeeLogDto.CreateDeleteLogRequest request) {

        // get after Employee log of same employeeNumber

        // insert ChangeLog as before and return entity

        // insert EmployeeLog

        // convert to ChangeLogDto and return

        return null;
    }


}
