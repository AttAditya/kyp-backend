package com.aaapis.kyp.repositories;

import com.aaapis.kyp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee save(Employee employee);
    Optional<Employee> findById(Long employeeId);
}
