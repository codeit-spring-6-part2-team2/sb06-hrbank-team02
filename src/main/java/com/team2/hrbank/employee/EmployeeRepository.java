package com.team2.hrbank.employee;

import com.team2.hrbank.employee.domain.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
    @Override
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query("DELETE FROM Employee e WHERE e.id = :id")
    void deleteById(Long id);
}
