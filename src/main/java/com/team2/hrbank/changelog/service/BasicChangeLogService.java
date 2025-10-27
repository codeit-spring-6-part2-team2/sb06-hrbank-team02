package com.team2.hrbank.changelog.service;

import com.team2.hrbank.changelog.domain.*;
import com.team2.hrbank.changelog.dto.*;
import com.team2.hrbank.changelog.mapper.ChangeLogMapper;
import com.team2.hrbank.changelog.repository.ChangeLogRepository;
import com.team2.hrbank.changelog.repository.EmployeeDetailLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BasicChangeLogService implements ChangeLogService{

    private final ChangeLogRepository changeLogRepository;
    private final EmployeeDetailLogRepository employeeDetailLogRepository;
    private final ChangeLogMapper changeLogMapper;
    
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
        return changeLogRepository.countChangeLogs(fromDate, toDate);
    }

    @Override
    public LocalDateTime getRecentLogDate() {
        // return recent log date from repository
        return changeLogRepository.findRecentLogDate().orElse(null);
    }

    @Transactional
    @Override
    public ChangeLogDto addEmployeeInsertLog(EmployeeLogDto.CreateLogRequest request) {

        // insert ChangeLog and return entity
        ChangeLog changeLog = changeLogRepository.save(ChangeLog.builder()
                .type(ChangeLogType.CREATED)
                .employeeNumber(request.employeeNumber())
                .memo(request.memo())
                .ipAddress(new IPAddress(request.ipAddress()))
                .build());

        // insert EmployeeLog as after log
        EmployeeDetailLog employeeDetailLog = EmployeeDetailLog.builder()
                .changeLog(changeLog)
                .type(EmployeeLogType.AFTER)
                .hireDate(request.hireDate())
                .name(request.employeeName())
                .position(request.employeePosition())
                .department(request.departmentName())
                .email(new EmployeeEmail(request.employeeEmail()))
                .status(request.employeeStatus())
                .build();

        employeeDetailLogRepository.save(employeeDetailLog);

        // convert to ChangeLogDto and return
        return changeLogMapper.toDto(changeLog);

    }

    @Transactional
    @Override
    public ChangeLogDto addEmployeeUpdateLog(EmployeeLogDto.CreateLogRequest request) {

        // get after Employee log of same employeeNumber
        EmployeeDetailLog beforeLog = employeeDetailLogRepository.findByEmployeeNumber(request.employeeNumber())
                .orElseThrow(() -> new IllegalArgumentException("해당 사원의 로그를 찾을 수 없습니다: " + request.employeeNumber()));

        beforeLog = EmployeeDetailLog.builder()
                .changeLog(beforeLog.getChangeLog())
                .type(EmployeeLogType.BEFORE)
                .hireDate(beforeLog.getHireDate())
                .name(beforeLog.getName())
                .position(beforeLog.getPosition())
                .department(beforeLog.getDepartment())
                .email(beforeLog.getEmail())
                .status(beforeLog.getStatus())
                .build();

        // insert ChangeLog and return entity
        ChangeLog changeLog = changeLogRepository.save(ChangeLog.builder()
                .type(ChangeLogType.UPDATED)
                .employeeNumber(request.employeeNumber())
                .memo(request.memo())
                .ipAddress(new IPAddress(request.ipAddress()))
                .build());

        // insert EmployeeLog
        EmployeeDetailLog afterLog = EmployeeDetailLog.builder()
                .changeLog(changeLog)
                .type(EmployeeLogType.AFTER)
                .hireDate(request.hireDate())
                .name(request.employeeName())
                .position(request.employeePosition())
                .department(request.departmentName())
                .email(new EmployeeEmail(request.employeeEmail()))
                .status(request.employeeStatus())
                .build();

        employeeDetailLogRepository.saveAll(List.of(beforeLog, afterLog));
        // convert to ChangeLogDto and return
        return changeLogMapper.toDto(changeLog);

    }

    @Transactional
    @Override
    public ChangeLogDto addEmployeeDeleteLog(EmployeeLogDto.CreateDeleteLogRequest request) {

        // get after Employee log of same employeeNumber
        EmployeeDetailLog beforeLog = employeeDetailLogRepository.findByEmployeeNumber(request.employeeNumber())
                .orElseThrow(() -> new IllegalArgumentException("해당 사원의 로그를 찾을 수 없습니다: " + request.employeeNumber()));

        // insert ChangeLog as before and return entity
        ChangeLog changeLog = changeLogRepository.save(ChangeLog.builder()
                .type(ChangeLogType.DELETED)
                .employeeNumber(request.employeeNumber())
                .ipAddress(new IPAddress(request.ipAddress()))
                .build());

        // insert EmployeeLog
        EmployeeDetailLog employeeDetailLog = EmployeeDetailLog.builder()
                .changeLog(changeLog)
                .type(EmployeeLogType.BEFORE)
                .hireDate(beforeLog.getHireDate())
                .name(beforeLog.getName())
                .position(beforeLog.getPosition())
                .department(beforeLog.getDepartment())
                .email(beforeLog.getEmail())
                .status(beforeLog.getStatus())
                .build();

        // convert to ChangeLogDto and return
        return changeLogMapper.toDto(changeLog);

    }


}
