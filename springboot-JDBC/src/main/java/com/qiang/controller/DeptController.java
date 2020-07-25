package com.qiang.controller;

import com.qiang.bean.Department;
import com.qiang.bean.Employee;
import com.qiang.mapper.DepartmentMapper;
import com.qiang.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
//import com.qiang.mapper.EmployeeMapper;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;


    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
        public Department getDept(@PathVariable("id") int id){
            return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    //只列举了通过ID查找，增删是一样的道理
    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") int id){
        return employeeMapper.getById(id);
    }

}
