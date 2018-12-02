package com.huangj.advance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangj
 * @version V1.0
 * @Title:
 * @Description: 首页 res DTO
 * @date 2018/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TestDto {

    private long totalSales;

    private String name;

}