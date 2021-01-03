package com.library.service;

import com.library.dao.AdminDao;
import com.library.entities.Admin;
import com.library.entities.returndata.IndexCharts;
import com.library.entities.usrpwd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {
    @Resource
    private AdminDao adminDao;

    //find by username and password
    public Admin findAdmin(usrpwd up) {
        return adminDao.findAdmin(up);
    }

    public List<Admin> findAdminByClick(Integer time) {
        return adminDao.findAdminByClick(time * 10, (time + 1) * 10);
    }

    public List<Admin> findAll() {
        return adminDao.findAll();
    }

    public List<Admin> findActive() {
        return adminDao.findStatusActive();
    }

    public void AddAdmin(Admin admin) {
        adminDao.AddAdmin(admin);
    }

    public IndexCharts findOnlineAndAll() {
        IndexCharts indexCharts = new IndexCharts();
        indexCharts.setDutyNum(adminDao.findOnline());
        indexCharts.setWorkerNum(adminDao.findNum());
        return indexCharts;
    }
}
