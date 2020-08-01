package com.qiang.service;

import com.qiang.bean.Employee;
import com.qiang.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService{
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmp(Integer id){
        System.out.println("查询"+id+"号员工");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
}