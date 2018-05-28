package com.huangj.advance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author huangj
 * @Description: table:t_we_chart
 * @date 2018/5/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WeChart {

    private String account;

    private String password;

    private String name;

    private Integer age;

    private Integer sexType;

    private Date createDate;

}
