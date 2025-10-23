package com.team2.hrbank.changelog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "change_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, onConstructor_ = @Deprecated)
public class ChangeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChangeLogType type;

    @Column(nullable = false)
    private String employeeNumber;

    private String memo;

    @Column(nullable = false)
    private String ipAddress;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Builder
    public ChangeLog(ChangeLogType type, String employeeNumber, String memo, String ipAddress) {
        this.type = Objects.requireNonNull(type);
        this.employeeNumber = Objects.requireNonNull(employeeNumber);
        this.memo = memo;
        this.ipAddress = Objects.requireNonNull(ipAddress);
        this.createdAt = LocalDateTime.now();
    }

}
