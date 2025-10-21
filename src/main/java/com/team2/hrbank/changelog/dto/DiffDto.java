package com.team2.hrbank.changelog.dto;

import lombok.Builder;

@Builder
public record DiffDto(
        String propertyName,
        String before,
        String after
) {
}
