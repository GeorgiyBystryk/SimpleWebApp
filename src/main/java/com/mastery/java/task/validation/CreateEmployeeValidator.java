package com.mastery.java.task.validation;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.BadRequestException;

public class CreateEmployeeValidator {

    public static boolean validate(Employee employee){
        if(employee.getFirstName().isEmpty()||employee.getFirstName()==null||
                employee.getLastName().isEmpty()||employee.getLastName()==null||
                employee.getDepartmentId()==null||employee.getDepartmentId()<=0||
                employee.getJobTitle().isEmpty()||employee.getJobTitle()==null||
                String.valueOf(employee.getGender()).isEmpty()||employee.getGender()==null){
            throw  new BadRequestException();
        }else {
            return true;

        }
    }

}