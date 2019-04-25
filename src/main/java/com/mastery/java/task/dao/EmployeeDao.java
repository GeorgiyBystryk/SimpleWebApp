package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Employee findById(Long employeeId) {

        String sql = "SELECT * FROM employee WHERE employee_id = ? ";

        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{employeeId}, new BeanPropertyRowMapper<Employee>(Employee.class));
        } catch (DataAccessException e) {
            throw new NotFoundException();
        }
    }

    public List<Employee> findAll() {
        String sql = "SELECT * FROM EMPLOYEE ORDER BY employee_id ASC";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }


    public void create(Employee employee) {

        String sql = "INSERT INTO employee (first_name, last_name, department_id, job_title, gender) VALUES (?,?,?,?,?)";

            jdbcTemplate.update(sql, new Object[]{
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDepartmentId(),
                    employee.getJobTitle(),
                    String.valueOf(employee.getGender())
            });





    }

    public void update(Employee employee) {

        String sqlCheck = "SELECT * FROM employee WHERE employee_id = ? ";
        String sql = "UPDATE employee SET first_name=?, last_name=?, department_id=?, job_title=?, gender=? WHERE employee_id=?";

        try {
            jdbcTemplate.queryForObject(sqlCheck, new Object[]{employee.getEmployeeId()}, new BeanPropertyRowMapper<Employee>(Employee.class));
        } catch (DataAccessException e) {
            throw new NotFoundException();
        }

        jdbcTemplate.update(sql, new Object[]{
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartmentId(),
                employee.getJobTitle(),
                String.valueOf(employee.getGender()),
                employee.getEmployeeId()
        });

    }


    public void delete(Long employeeId) {

        String sqlCheck = "SELECT * FROM employee WHERE employee_id = ? ";
        String sql = "DELETE FROM employee WHERE employee_id=?";

        try {
            jdbcTemplate.queryForObject(sqlCheck, new Object[]{employeeId}, new BeanPropertyRowMapper<Employee>(Employee.class));
        } catch (DataAccessException e) {
            throw new NotFoundException();
        }

        jdbcTemplate.update(sql, employeeId);

    }

}


