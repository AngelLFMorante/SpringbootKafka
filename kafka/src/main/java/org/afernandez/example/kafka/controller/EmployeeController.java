package org.afernandez.example.kafka.controller;

import org.afernandez.example.kafka.model.Employee;
import org.afernandez.example.kafka.producer.KafkaProducer;
import org.afernandez.example.kafka.service.EmployeeService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;
    private final KafkaProducer kafkaProducer;

    public EmployeeController(EmployeeService service, KafkaProducer kafkaProducer) {
        this.service = service;
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = service.saveEmployee(employee);
        kafkaProducer.sendMessage("Empleado creado: " + savedEmployee.getName());
        return savedEmployee;
    }
}

