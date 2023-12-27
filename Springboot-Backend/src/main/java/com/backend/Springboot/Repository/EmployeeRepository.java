package com.backend.Springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.Springboot.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
