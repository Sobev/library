package com.library.dao;

import com.library.entities.ReaderCategory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReaderCategoryDao {
    List<ReaderCategory> getAll();

    @Transactional
    void save(ReaderCategory cid);

    @Transactional
    void delete(String cid);

    void alter(ReaderCategory category);

    ReaderCategory getByCId(String cid);
}
