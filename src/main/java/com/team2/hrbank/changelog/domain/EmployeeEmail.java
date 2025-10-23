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

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && email.matches(emailRegex);
    }

    public static EmployeeEmail of(String email) {

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("유효하지 않은 이메일 주소입니다: " + email);
        }

        return new EmployeeEmail(email);

    }

}
