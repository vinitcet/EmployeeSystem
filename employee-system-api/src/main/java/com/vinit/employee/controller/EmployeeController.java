package com.vinit.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import com.vinit.employee.entity.Employee;
import com.vinit.employee.model.EmployeeModel;
import com.vinit.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController
{
    @Autowired
    private EmployeeService m_employeeService;

    @PostMapping("/employee")
    public EmployeeModel createEmployee( @RequestBody EmployeeModel employee )
    {
        return m_employeeService.createEmployee( employee );
    }

    @GetMapping("/employee")
    public List<EmployeeModel> getAllEmployees()
    {
        return m_employeeService.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee( @PathVariable Long id )
    {
        boolean deleted = m_employeeService.deleteEmployee( id );
        Map<String, Boolean> response = new HashMap<>();
        response.put( "deleted", deleted );
        return ResponseEntity.ok( response );
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeModel> getEmployee( @PathVariable Long id )
    {
        EmployeeModel employee = m_employeeService.getEmployee( id );
        return ResponseEntity.ok( employee );
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee( @PathVariable Long id,
                                                         @RequestBody EmployeeModel employee )
    {
        employee = m_employeeService.updateEmployee( id, employee );
        return ResponseEntity.ok( employee );
    }
}
