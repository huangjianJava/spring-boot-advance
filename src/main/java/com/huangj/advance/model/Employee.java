package com.huangj.advance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author huangj
 * @Description: table:t_employee
 * @date 2018/5/31
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	private Integer id;

    private String name;

    private String email;

    //1 male, 0 female
    private Integer gender;

    private Date birth;

}
