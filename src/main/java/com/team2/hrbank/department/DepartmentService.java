package com.team2.hrbank.department;

import com.team2.hrbank.department.dto.DepartmentCreateRequest;
import com.team2.hrbank.department.dto.DepartmentDto;
import com.team2.hrbank.department.dto.DepartmentUpdateRequest;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentCreateRequest request);

    DepartmentDto updateDepartment(Long id, DepartmentUpdateRequest request);

    void deleteDepartment(Long id);

    DepartmentDto getDepartment(Long id);

    List<DepartmentDto> getDepartments(String name, String description, String sortBy, Long lastId, int pageSize);

    long getEmployeeCount(Long departmentId);
}
