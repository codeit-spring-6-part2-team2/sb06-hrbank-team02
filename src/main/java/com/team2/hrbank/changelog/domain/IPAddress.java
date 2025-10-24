package com.team2.hrbank.changelog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED, onConstructor_ = @Deprecated)
public class IPAddress {

    @Column(name = "ip_address", nullable = false)
    private String ipAddress;

    protected IPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    private static boolean isValidAddress(String ipAddress) {

        String ipV4Regex = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        String ipV6Regex = "^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$|^::1$|^::$";

        return ipAddress.matches(ipV4Regex) || ipAddress.matches(ipV6Regex);
    }

    public static IPAddress of(String ipAddress) {

        if (ipAddress == null || !isValidAddress(ipAddress)) {
            throw new IllegalArgumentException("유효하지 않은 IP 주소입니다: " + ipAddress);
        }

        return new IPAddress(ipAddress);

    }

}
