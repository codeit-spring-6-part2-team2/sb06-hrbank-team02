package com.team2.hrbank.employee.domain;

import com.team2.hrbank.employee.domain.exception.EmployeeNameEmptyException;
import com.team2.hrbank.employee.domain.exception.EmployeePositionEmptyException;
import jakarta.persistence.*;
import org.jspecify.annotations.Nullable;

import java.time.LocalDate;
import java.util.Optional;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "uk_employee_email", columnNames = "email"),
        @UniqueConstraint(name = "uk_employee_number", columnNames = "employee_number")
})
public class Employee {

    @Nullable
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Embedded
    private EmployeeEmail email;

    @Embedded
    private EmployeeNumber employeeNumber;

    @Column(nullable = false)
    private Long departmentId;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EmployeeStatus status;

    @Nullable
    private Long profileImageId;

    @Deprecated(since = "JPA 명세에 의해 필요함")
    protected Employee() {
    }

    protected Employee(
            @Nullable Long id,
            String name,
            EmployeeEmail email,
            EmployeeNumber employeeNumber,
            Long departmentId,
            String position,
            LocalDate hireDate,
            EmployeeStatus status,
            @Nullable Long profileImageId
    ) {
        this.id = id;
        this.name = this.requireName(name.trim());
        this.email = email;
        this.employeeNumber = employeeNumber;
        this.departmentId = departmentId;
        this.position = this.requirePosition(position.trim());
        this.hireDate = hireDate;
        this.status = status;
        this.profileImageId = profileImageId;
    }

    public Employee updateName(String newName) {
        this.name = requireName(newName.trim());
        return this;
    }

    public Employee updateEmail(EmployeeEmail newEmail) {
        this.email = newEmail;
        return this;
    }

    public Employee updateDepartmentId(Long newDepartmentId) {
        this.departmentId = newDepartmentId;
        return this;
    }

    public Employee updatePosition(String newPosition) {
        this.position = requirePosition(newPosition.trim());
        return this;
    }

    public Employee updateHireDate(LocalDate newHireDate) {
        this.hireDate = newHireDate;
        return this;
    }

    public Employee updateStatus(EmployeeStatus newStatus) {
        this.status = newStatus;
        return this;
    }

    public Employee updateProfileImageId(@Nullable Long newProfileImageId) {
        this.profileImageId = newProfileImageId;
        return this;
    }

    private String requireName(String name) {
        if (name.isBlank()) {
            throw new EmployeeNameEmptyException();
        }
        return name;
    }

    private String requirePosition(String position) {
        if (position.isBlank()) {
            throw new EmployeePositionEmptyException();
        }
        return position;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public Optional<Long> getProfileImageId() {
        return Optional.ofNullable(profileImageId);
    }
}


