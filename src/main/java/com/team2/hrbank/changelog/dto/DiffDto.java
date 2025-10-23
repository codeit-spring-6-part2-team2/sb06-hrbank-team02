package com.team2.hrbank.changelog.dto;

import lombok.Builder;

public record DiffDto(
        String propertyName,
        String before,
        String after
) {

    public DiffDto with(String propertyName, String before, String after) {
        return new DiffDto(propertyName, before, after);
    }

    public DiffDto withBefore(String propertyName, String before) {
        return new DiffDto(propertyName, before, null);
    }

    public DiffDto withAfter(String propertyName, String after) {
        return new DiffDto(propertyName, null, after);
    }

}
