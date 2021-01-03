package com.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Admin implements Serializable {
    private String adminId;//管理员id
    private Integer status;//状态 值班 or 放假
    private String email;
    private String location;
    private String phone;
    private String office;
    private Integer sex;
    private String workId;//员工号
    private String pwd;//密码
    private Integer age;
}
