package com.team2.hrbank.changelog.mapper;

import com.team2.hrbank.changelog.domain.ChangeLog;
import com.team2.hrbank.changelog.dto.ChangeLogDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChangeLogMapper {

    ChangeLogDto toDto(ChangeLog changeLog);

}
