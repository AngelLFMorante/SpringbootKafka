package org.afernandez.example.kafka.repository;


import org.afernandez.example.kafka.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
