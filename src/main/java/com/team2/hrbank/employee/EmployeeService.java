package com.team2.hrbank.employee;

import com.team2.hrbank.employee.domain.EmployeeStatus;
import com.team2.hrbank.employee.dto.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployees();

    EmployeeDto addEmployee(EmployeeCreateRequest employee, MultipartFile profile);

    EmployeeDto getEmployee(Long id);

    void deleteEmployee(Long id);

    EmployeeDto updateEmployee(EmployeeUpdateRequest employee, MultipartFile profile);

    List<EmployeeTrendDto> getEmployeeTrends(LocalDate from, LocalDate to, String unit);

    List<EmployeeDistributionDto> getEmployeeDistributions(String groupBy, EmployeeStatus status);

    Long getEmployeeCount(EmployeeStatus status, LocalDate fromDate, LocalDate toDate);

    BackupEmployeePageResponseDto getEmployees(BackupEmployeePageRequestDto employee);

    List<DepartmentEmployeeCountDto> findEmployeeCountsByDepartmentId();
}
