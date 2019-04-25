package com.mastery.java.task.service;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.BadRequestException;
import org.junit.Test;


public class EmployeeServiceTest {


    @Test(expected = BadRequestException.class)
    public void createException() {

        EmployeeService employeeService = new EmployeeService();

        Employee employee1 = new Employee("", "Smith", 1L, "QA", "FEMALE");

        employeeService.create(employee1);
    }
}
