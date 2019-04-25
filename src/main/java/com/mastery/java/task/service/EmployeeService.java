package com.mastery.java.task.service;

import com.mastery.java.task.dao.EmployeeDao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.BadRequestException;
import com.mastery.java.task.exceptions.NotFoundException;
import com.mastery.java.task.validation.CreateEmployeeValidator;
import com.mastery.java.task.validation.UpdateEmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    EmployeeDao employeeDao;


    public Employee findById(Long employeeId) {
        if(employeeId==null){
            throw new NotFoundException();
        }else {
            return employeeDao.findById(employeeId);
        }

    }

    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    public void create(Employee employee) {

        CreateEmployeeValidator.validate(employee);
        employeeDao.create(employee);

    }

    public void update(Employee employee) {

        UpdateEmployeeValidator.validate(employee);
        employeeDao.update(employee);

    }

    public void deleteEmployee(Long id) {

        employeeDao.delete(id);
    }


}
