package com.team2.hrbank.changelog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, onConstructor_ = @Deprecated)
public class EmployeeEmail {

    @Column(name = "email", nullable = false)
    private String email;

    protected EmployeeEmail(String email) {
        this.email = email;
    }

    public static void validateEmail(String email) {

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (email == null || !email.matches(emailRegex)) {
            throw new IllegalArgumentException("유효하지 않은 이메일 주소입니다: " + email);
        }

    }

    public static EmployeeEmail of(String email) {

        validateEmail(email);

        return new EmployeeEmail(email);

    }

}
