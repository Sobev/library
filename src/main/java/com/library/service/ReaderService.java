package com.library.service;

import com.library.dao.ReaderDao;
import com.library.entities.Reader;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReaderService {
    @Resource
    private ReaderDao readerDao;

    public List<Reader> getAll() {
        return readerDao.getAll();
    }

    public void save(Reader reader) {
        readerDao.save(reader);
    }

    public void delete(String cardId) {
        readerDao.delete(cardId);
    }

    public void alter(Reader reader) {
        readerDao.alter(reader);
    }

    public Reader getById(String id) {
        return readerDao.getById(id);
    }
}
