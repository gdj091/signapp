package com.example.signapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.signapp.dto.Employee;
import com.example.signapp.mapper.EmployeeMapper;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public boolean join(Employee employee) {
        return employeeMapper.insertEmployee(employee) > 0;
    }
    
    public Employee login(Employee employee) {
        return employeeMapper.login(employee);
    }
}