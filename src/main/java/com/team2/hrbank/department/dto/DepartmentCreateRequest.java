package com.team2.hrbank.department.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DepartmentCreateRequest {
    @NotBlank(message = "부서 이름은 필수입니다.")
    @Size(max = 100, message = "이름은 100자 이내여야 합니다.")
    private final String name;

    @NotBlank(message = "설명은 필수입니다.")
    private final String description;

    @NotNull(message = "설립일은 필수입니다.")
    private final LocalDate establishedDate;

}
