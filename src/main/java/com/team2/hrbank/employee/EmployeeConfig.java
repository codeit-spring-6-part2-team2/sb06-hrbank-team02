package com.team2.hrbank.employee;

import com.team2.hrbank.employee.domain.BasicEmployeeFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public BasicEmployeeFactory employeeFactory() {
        return new BasicEmployeeFactory();
    }
}
