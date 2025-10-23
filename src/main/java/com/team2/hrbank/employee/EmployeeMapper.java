package com.team2.hrbank.employee;

import com.team2.hrbank.employee.domain.Employee;
import com.team2.hrbank.employee.dto.EmployeeCreateRequest;
import com.team2.hrbank.employee.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface EmployeeMapper {

    Employee toEntity(EmployeeCreateRequest employee);

    EmployeeDto toDto(Employee employee);
}
