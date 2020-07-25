package com.qiang.mapper;

import com.qiang.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    public Employee getById(int id);
    public void insertEmp(Employee employee);
}
