package com.huangj.advance.controller;

import com.huangj.advance.dao.EmployeeDao;
import com.huangj.advance.model.Employee;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author huangj
 * @Description:  员工信息 controller
 * @date 2018/5/31
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @PostMapping(value = "/employee")
    public String addEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employees";
    }

    @GetMapping(value = "/employee",produces = MediaType.APPLICATION_JSON_VALUE)
    public String routeToEmployeeAddView(ModelMap map){
        return "emp/addEmp";
    }

    @GetMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
    public String queryAllEmployees(ModelMap map){
        // 查询所有的员工信息
        List<Employee> employees =  employeeDao.findAll();
        map.addAttribute("employees",employees);
        return "emp/employee";
    }

}



