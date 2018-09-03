package com.huangj.advance.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author huangj
 * @version V1.0
 * @title: 用于测试菜单级联加载
 * @description:
 * @date 2018/8/31
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuResDto {

    @ApiModelProperty(value = "id")
    private int id;

    @ApiModelProperty(value = "父菜单ID，一级菜单为0")
    private int parentId;

    private String name;

    @ApiModelProperty(value = "子菜单", name = "子菜单")
    private List<MenuResDto> children;

}