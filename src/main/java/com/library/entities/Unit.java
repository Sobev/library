package com.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Unit implements Serializable {
    private String unitId;//单位id
    private String name;//单位名称
    private Integer nature;//性质
    private String location;
    private String remarks;//单位备注
    private String phone;
}
