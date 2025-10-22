package com.team2.hrbank.department;

import com.team2.hrbank.department.dto.CursorPageResponseDepartmentDto;
import com.team2.hrbank.department.dto.DepartmentCreateRequest;
import com.team2.hrbank.department.dto.DepartmentDto;
import com.team2.hrbank.department.dto.DepartmentUpdateRequest;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentCreateRequest request);

    DepartmentDto updateDepartment(Long id, DepartmentUpdateRequest request);

    void deleteDepartment(Long id);

    DepartmentDto getDepartment(Long id);

    CursorPageResponseDepartmentDto getDepartments(String nameOrDescription, String sortField, String sortDirection, Long idAfter, int size);
}
