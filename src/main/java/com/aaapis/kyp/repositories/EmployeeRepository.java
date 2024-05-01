package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee save(Employee employee);
    Optional<Employee> findById(Long employeeId);
}
