package com.vinit.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel
{
    private long Id;
    private String firstName;
    private String lastName;
    private String email;
}
