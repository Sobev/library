package com.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reader implements Serializable {
    private String cardId;
    private Integer readerCategoryId;
    private String email;
    private Integer status;//是否可借书
    private String phone;
    private String location;
    private Integer age;
    private String unitId;//单位Id
    private Integer borrowNum;//借书总数
    private String pwd;
    private Date date;//注册日期
}
