package com.team2.hrbank.changelog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "employee_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String employeeNumber;

    @Column(nullable = false)
    private String status;

    @Builder
    public EmployeeLog(EmployeeLogType type, Long changeLogId, LocalDateTime hireDate, String name,
                       String position, String department, String email, String employeeNumber, String status) {
        this.type = type;
        this.changeLogId = changeLogId;
        this.hireDate = hireDate;
        this.name = name;
        this.position = position;
        this.department = department;
        this.email = email;
        this.employeeNumber = employeeNumber;
        this.status = status;
    }

}
