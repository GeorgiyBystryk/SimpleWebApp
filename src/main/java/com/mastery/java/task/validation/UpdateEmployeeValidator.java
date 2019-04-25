package com.mastery.java.task.validation;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.BadRequestException;

public class UpdateEmployeeValidator {

    public static boolean validate(Employee employee){
        if(employee.getEmployeeId()==null||employee.getEmployeeId()<=0||!CreateEmployeeValidator.validate(employee)){
           throw  new BadRequestException();
        }else {
            return true;

        }
    }

}