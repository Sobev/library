package com.library.service;

import com.library.dao.ReaderCategoryDao;
import com.library.entities.ReaderCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReaderCategoryService {
    @Resource
    ReaderCategoryDao dao;

    public List<ReaderCategory> getAll() {
        return dao.getAll();
    }

    public void save(ReaderCategory category) {
        dao.save(category);
    }

    public void delete(String cid) {
        dao.delete(cid);
    }

    public void alter(ReaderCategory category) {
        dao.alter(category);
    }

    public ReaderCategory findById(String cid) {
        return dao.getByCId(cid);
    }
}
