package com.team2.hrbank.changelog.dto;

import lombok.Builder;

@Builder
public record CursorPageResponseChangeLogDto<T>(
        T[] contents,
        String nextCursor,
        Long nextIdAfter,
        Integer size,
        Long totalElements,
        Boolean hasNext
) {
}
