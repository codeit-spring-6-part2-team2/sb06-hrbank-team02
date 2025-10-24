package com.team2.hrbank.department.dto;

import com.team2.hrbank.department.domain.Department;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    Department toEntity(DepartmentCreateRequest dto);

    DepartmentDto toDto(Department entity);

    List<DepartmentDto> toDtoList(List<Department> entities);
}
