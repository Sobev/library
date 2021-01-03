package com.library.dao;

import com.library.entities.Unit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UnitDao {
    List<Unit> getAll();

    @Transactional
    void save(Unit unit);

    @Transactional
    void delete(String unitId);

    @Transactional
    void alter(Unit unit);

    Unit getById(String unitId);

}
