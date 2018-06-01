package com.huangj.advance.controller;

import com.huangj.advance.common.ErrorCode;
import com.huangj.advance.dao.EmployeeDao;
import com.huangj.advance.exception.ServiceException;
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

    /**
     * 删除指定员工信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/employee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String routeToEmployeeEditView(@PathVariable Integer id){
        employeeDao.deleteById(id);
        return "redirect:/employees";
    }

    /**
     * 路由到员工编辑界面并填充员工信息
     * @param id
     * @param map
     * @return
     */
    @GetMapping(value = "/employee/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String routeToEmployeeEditView(@PathVariable Integer id ,ModelMap map){
        Employee employee = employeeDao.findOneById(id);
        map.addAttribute("employee",employee);
        return "emp/addEmp";
    }

    /**
     * 添加员工信息
     * @param employee
     * @return
     */
    @PostMapping(value = "/employee")
    public String addOrUpdateEmployee(Employee employee){
        if(!"admin".equals(employee.getName())){
            throw new ServiceException(ErrorCode.BAD_REQUEST);
        }

        employeeDao.saveOrUpdate(employee);
        return "redirect:/employees";
    }

    /**
     * 路由到员工添加界面
     * @param map
     * @return
     */
    @GetMapping(value = "/employee",produces = MediaType.APPLICATION_JSON_VALUE)
    public String routeToEmployeeAddView(ModelMap map){
        return "emp/addEmp";
    }

    /**
     * 查询员工列表
     * @param map
     * @return
     */
    @GetMapping(value = "/employees",produces = MediaType.APPLICATION_JSON_VALUE)
    public String queryAllEmployees(ModelMap map){
        // 查询所有的员工信息
        List<Employee> employees =  employeeDao.findAll();
        map.addAttribute("employees",employees);
        return "emp/employee";
    }

}



