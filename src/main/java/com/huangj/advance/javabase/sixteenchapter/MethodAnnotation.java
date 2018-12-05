package com.huangj.advance.javabase.sixteenchapter;

import java.lang.annotation.*;

/**
 * @author huangj
 * @version V1.0
 * @Title:	自定义用于方法的注解
 * @Description:
 * @date 2018/12/5
 */
@Target(ElementType.METHOD)   
@Retention(RetentionPolicy.RUNTIME)    
@Documented
public @interface MethodAnnotation {

	String display() default "默认值";

}
