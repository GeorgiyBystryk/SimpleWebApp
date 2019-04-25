package com.mastery.java.task.validation;

import com.mastery.java.task.dto.Employee;
import org.junit.Assert;
import org.junit.Test;

public class CreateEmployeeValidatorTest {

    @Test
    public void validate(){

        Employee employee = new Employee("John", "Smith", 1L, "QA", "MALE");

        Assert.assertTrue(CreateEmployeeValidator.validate(employee));
    }

}
