package com.team2.hrbank.employee;

import com.team2.hrbank.employee.domain.Employee;
import com.team2.hrbank.employee.domain.EmployeeStatus;
import com.team2.hrbank.employee.dto.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class BasicEmployeeService implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    public BasicEmployeeService(EmployeeMapper employeeMapper, EmployeeRepository employeeRepository) {
        this.employeeMapper = employeeMapper;
        this.employeeRepository = employeeRepository;
    }

    // TODO 구현
    @Override
    public EmployeeDto getEmployees(CursorPageRequestEmployeeDto request) {
        return null;
    }

    // TODO 변경 사항 저장, 이미지 파일 저장
    @Override
    @Transactional
    public EmployeeDto addEmployee(EmployeeCreateRequest request, MultipartFile profile) {
        Employee employee = employeeMapper.toEntity(request);
        Employee saved = employeeRepository.save(employee);
        return employeeMapper.toDto(saved);
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
        return employeeMapper.toDto(employee);
    }

    // TODO 변경 사항 저장, 이미지 파일 삭제
    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    // TODO 구현, 변경 사항 저장, 이미지 삭제, 이미지 추가
    @Override
    @Transactional
    public EmployeeDto updateEmployee(EmployeeUpdateRequest employee, MultipartFile profile) {
        return null;
    }

    // TODO 구현
    @Override
    public List<EmployeeTrendDto> getEmployeeTrends(LocalDate from, LocalDate to, String unit) {
        return List.of();
    }

    // TODO 구현
    @Override
    public List<EmployeeDistributionDto> getEmployeeDistributions(String groupBy, EmployeeStatus status) {
        return List.of();
    }

    // TODO 구현
    @Override
    public Long getEmployeeCount(EmployeeStatus status, LocalDate fromDate, LocalDate toDate) {
        return 0L;
    }
}
