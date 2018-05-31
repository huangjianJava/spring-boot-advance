package com.huangj.advance.dao;

import com.google.common.collect.Maps;
import com.huangj.advance.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author huangj
 * @Description:  员工 dao
 * @date 2018/5/31
 */
@Repository
public class EmployeeDao {

	/** 当做员工的数据源 */
	private static Map<Integer, Employee> employees = null;
	
	static{
		employees = Maps.newHashMap();
		employees.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1,new Date()));
		employees.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Date()));
		employees.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Date()));
		employees.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Date()));
		employees.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Date()));
	}
	
	private static Integer initId = 1006;
	
	public void saveOrUpdate(Employee employee){
		if(employee.getId() == null){
			employee.setId(initId++);
		}
		employees.put(employee.getId(), employee);
	}
	
	public List<Employee> findAll(){
		return employees.values().stream()
				.collect(Collectors.toList());
	}
	
	public Employee findOneById(Integer id){
		return employees.get(id);
	}
	
	public void deleteById(Integer id){
		employees.remove(id);
	}
}














