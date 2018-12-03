package com.huangj.advance.dto;

import lombok.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author huangj
 * @version V1.0
 * @Title:
 * @Description: 首页 res DTO
 * @date 2018/11/14
 */
//@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TestDto {

    private long totalSales;

    private String name;

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this,obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}