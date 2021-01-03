package com.library.service;

import com.library.dao.PublishingDao;
import com.library.entities.Publishing;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PublishingService {
    @Resource
    private PublishingDao dao;

    public List<Publishing> getAll() {
        return dao.getAll();
    }

    public void save(Publishing p) {
        dao.save(p);
    }

    public void delete(String p) {
        dao.delete(p);
    }

    public void alter(Publishing p) {
        dao.alter(p);
    }

    public Publishing getById(String id) {
        return dao.getById(id);
    }
}
