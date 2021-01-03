package com.library.service;

import com.library.dao.UnitDao;
import com.library.entities.Unit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UnitService {
    @Resource
    UnitDao dao;

    public List<Unit> getAll() {
        return dao.getAll();
    }

    public void save(Unit unit) {
        dao.save(unit);
    }

    @Transactional
    public void delete(String id) {
        dao.delete(id);
    }

    @Transactional
    public void alter(Unit unit) {
        dao.alter(unit);
    }

    public Unit getById(String id) {
        return dao.getById(id);
    }
}
