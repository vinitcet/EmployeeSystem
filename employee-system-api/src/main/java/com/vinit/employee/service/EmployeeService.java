package com.vinit.employee.service;

import java.util.List;

import com.vinit.employee.entity.Employee;
import com.vinit.employee.model.EmployeeModel;

public interface EmployeeService
{
    EmployeeModel createEmployee( EmployeeModel employee );

    List<EmployeeModel> getAllEmployees();

    boolean deleteEmployee( Long id );

    EmployeeModel getEmployee( Long id );

    EmployeeModel updateEmployee( Long id, EmployeeModel employee );
}
