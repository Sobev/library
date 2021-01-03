package com.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BorrowBook implements Serializable {
    private Integer borrowId;
    private String bookId;
    private String cardId;
    private String adm_adminid;//借阅操作员员工号 workid
    private String adminId;//归还操作员员工号 workid
    private Date outDate;
    private Date backDate;
    private Integer continueTime;//续借次数
    private Date continueDate;//续借时间
    private Integer outofDate;//超期时间
    private Float outMoney;//超期费用
}
