package com.huangj.advance.common;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @author huangj
 * @Description:    Email 数据配置类
 * @date 2018/6/15
 */
@Data
@Builder
public class EmailDataConfig {

    private String title;

    private String content;

    private List<String> toUsers;

    //java mail 的inline语法,用于内置资源文件,比如内置图片
    private Map<String,Object> inlines;

    //附件
    private Map<String,Object> attachments;
}
