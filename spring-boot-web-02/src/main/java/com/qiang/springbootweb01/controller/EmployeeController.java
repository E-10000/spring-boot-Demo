package com.qiang.springbootweb01.controller;

import com.qiang.springbootweb01.dao.DepartmentDao;
import com.qiang.springbootweb01.dao.EmployeeDao;
import com.qiang.springbootweb01.entities.Department;
import com.qiang.springbootweb01.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;



    //获得全部员工信息
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //map
        model.addAttribute("emps",employees);
        return "list";
    }

    //跳转到添加页面
    @GetMapping(value = "/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "add";
    }

    //添加员工的操作
    @PostMapping(value = "/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        System.out.println(employee);
        //重定向，请求为/emp，这样就能到list.html了
        return "redirect:/emps";
    }

    //跳转到编辑页面
    //   /emp/1001   /emp/{id}   id==>1001
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee=employeeDao.get(id);
        model.addAttribute("emp",employee);
        //用于显示有什么部门可选
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        System.out.println(employee);
        return "edit";
    }

    //编辑员工操作
    @PutMapping("/emp")
    public String edit(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        System.out.println(id);
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
