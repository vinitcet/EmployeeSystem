package com.vinit.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import com.vinit.employee.entity.Employee;
import com.vinit.employee.model.EmployeeModel;
import com.vinit.employee.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpoloyeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository m_employeeRepository;

    @Override
    public EmployeeModel createEmployee( final EmployeeModel employee )
    {
        Employee employee_entity = new Employee();
        BeanUtils.copyProperties( employee, employee_entity );
        m_employeeRepository.save( employee_entity );
        employee.setId( employee_entity.getId() );
        return employee;
    }

    @Override
    public List<EmployeeModel> getAllEmployees()
    {
        List<Employee> employeeList = m_employeeRepository.findAll();

        List<EmployeeModel> employeeModelList =
            employeeList
                .stream()
                .map( emp -> new EmployeeModel( emp.getId(),
                                                emp.getFirstName(),
                                                emp.getLastName(),
                                                emp.getEmail() ) )
                .collect( Collectors.toList() );

        return employeeModelList;
    }

    @Override
    public boolean deleteEmployee( final Long id )
    {
        Employee emp = m_employeeRepository.findById( id ).get();
        m_employeeRepository.delete( emp );
        return true;
    }

    @Override
    public EmployeeModel getEmployee( final Long id )
    {
        Employee emp = m_employeeRepository.findById( id ).get();
        EmployeeModel employee = new EmployeeModel();
        BeanUtils.copyProperties( emp, employee );
        return employee;
    }

    @Override
    public EmployeeModel updateEmployee( final Long id, final EmployeeModel employee )
    {
        Employee emp = m_employeeRepository.findById( id ).get();
        emp.setEmail( employee.getEmail() );
        emp.setFirstName( employee.getFirstName() );
        emp.setLastName( employee.getLastName() );
        m_employeeRepository.save( emp );
        return employee;
    }
}
