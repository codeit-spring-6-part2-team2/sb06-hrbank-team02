package com.team2.hrbank.changelog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jspecify.annotations.Nullable;

import java.time.LocalDateTime;

@Entity
@Table(name = "change_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, onConstructor_ = @Deprecated)
public class ChangeLog {

    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ChangeLogType type;

    @Column(nullable = false)
    private String employeeNumber;

    private String memo;

    @Embedded
    private IPAddress ipAddress;

    @Column(nullable = false, updatable = false)
    private LocalDateTime at;

    @Builder
    public ChangeLog(ChangeLogType type, String employeeNumber, @Nullable String memo, String ipAddress) {
        this.type = type;
        this.employeeNumber = employeeNumber;
        this.memo = memo;
        this.ipAddress = IPAddress.of(ipAddress);
    }

    @PrePersist
    protected void onCreate() {
        this.at = LocalDateTime.now();
    }

}
