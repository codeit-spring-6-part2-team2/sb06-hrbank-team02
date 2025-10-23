package com.team2.hrbank.changelog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "employee_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, onConstructor_ = @Deprecated)
public class EmployeeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeLogType type;

    @Column(nullable = false)
    private Long changeLogId;

    @Column(nullable = false)
    private LocalDateTime hireDate;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String department;

    @Embedded
    private EmployeeEmail email;

    @Column(nullable = false)
    private String status;

    @Builder
    public EmployeeLog(EmployeeLogType type, Long changeLogId, LocalDateTime hireDate, String name,
                       String position, String department, String email, String status) {
        this.type = Objects.requireNonNull(type, "EmployeeLogType은 null일 수 없습니다.");
        this.changeLogId = Objects.requireNonNull(changeLogId, "ChangeLog ID는 null일 수 없습니다.");
        this.hireDate = Objects.requireNonNull(hireDate, "입사일은 null일 수 없습니다.");
        this.name = Objects.requireNonNull(name, "이름은 null일 수 없습니다.");
        this.position = Objects.requireNonNull(position, "직급은 null일 수 없습니다.");
        this.department = Objects.requireNonNull(department, "부서는 null일 수 없습니다.");
        this.email = EmployeeEmail.of(email);
        this.status = Objects.requireNonNull(status, "상태는 null일 수 없습니다.");
    }

}
