package com.jdbc.controller;

import com.jdbc.dao.EmployeeDAO;
import com.jdbc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDAO eDAO;

    @Autowired

    @GetMapping("/employees")
    public List<Employee> getEmployee()
    {
        return  eDAO.getAll();
    }

    @GetMapping("/employees/{id}")
    public  Employee getEmployeeById(@PathVariable int id)
    {
        return eDAO.getById(id);
    }




    @PutMapping("/employees/{id}")
    public  String updateEmployee(@RequestBody Employee employee,@PathVariable int id)
    {
        return eDAO.update(employee, id)+"No of rows updated to the database";
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable int id)
    {
        return  eDAO.delete(id)+"No of rows deleted";
    }
}
