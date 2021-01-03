package com.library.dao;

import com.library.entities.Reader;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReaderDao {
    List<Reader> getAll();

    @Transactional
    void save(Reader reader);

    @Transactional
    void delete(String cardId);

    void alter(Reader reader);

    Reader getById(String cardId);
}
