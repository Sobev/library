package com.library.dao;

import com.library.entities.Admin;
import com.library.entities.usrpwd;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdminDao {
    Admin findAdmin(usrpwd up);

    List<Admin> findAdminByClick(@Param("start") Integer start, @Param("end") Integer end);

    List<Admin> findAll();

    List<Admin> findStatusActive();

    @Transactional
    void AddAdmin(Admin admin);

    Integer findNum();

    Integer findOnline();
}
