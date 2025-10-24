package com.team2.hrbank.changelog.dto;

import lombok.Builder;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

public class EmployeeLogDto {

    private EmployeeLogDto() {
    }

    @Builder
    public record EmployeeBaseInfo(
            LocalDateTime hireDate,
            String name,
            String position,
            String department,
            String email,
            String employeeNumber,
            String status,
            //퇴사 여부를 판단하기 위한 필드
            boolean isRetired
    ) {}

    public record LogMetadata(
            @Nullable
            String memo,
            String ipAddress
    ) {

        public static LogMetadata withMemo(String ipAddress, String memo) {
            return new LogMetadata(memo, ipAddress);
        }

        public static LogMetadata withoutMemo(String ipAddress) {
            return new LogMetadata(null, ipAddress);
        }

    }

    @Builder
    public record CreateLogRequest(
            EmployeeBaseInfo employeeInfo,
            LogMetadata metadata
    ) {}

    /*@Builder
    public record CreateUpdateLogRequest(
            EmployeeBaseInfo before,
            EmployeeBaseInfo after,
            LogMetadata metadata
    ) {}

    @Builder
    public record CreateDeleteLogRequest(
            EmployeeBaseInfo employeeInfo,
            LogMetadata metadata
    ) {}*/

}
