package com.example.signapp.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.signapp.dto.Employee;

@Mapper
public interface EmployeeMapper {
    int insertEmployee(Employee employee);
    Employee login(Employee employee);
}