package com.huangj.advance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author huangj
 * @Description: table:t_sys_user
 * @date 2018/6/19
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_sys_user")
public class SysUserModel {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 用户名
     */
    @Column(name = "username")
    private String username;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 角色
     */
    @Column(name = "role")
    private String role;

}
