package com.team2.hrbank.department.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DepartmentUpdateRequest {
    @NotBlank(message = "부서 이름은 필수입니다.")
    private final String name;

    @NotBlank(message = "설명은 필수입니다.")
    private final String description;

    @NotNull(message = "설립일은 필수입니다.")
    private final LocalDate establishedDate;

}
