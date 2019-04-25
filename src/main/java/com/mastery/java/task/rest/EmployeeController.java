package com.mastery.java.task.rest;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("{id}")
    public Employee findByID(@PathVariable(value = "id") Long employeeId){

        return employeeService.findById(employeeId);
    }

    @GetMapping("/All")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Object> create(@ModelAttribute Employee employee){

        employeeService.create(employee);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/simplewebapp/employeesAll.html"))
                .build();
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Object> update(@ModelAttribute Employee employee){

        employeeService.update(employee);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/simplewebapp/employeesAll.html"))
                .build();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable(value = "id") Long id){
        employeeService.deleteEmployee(id);
    }

}


