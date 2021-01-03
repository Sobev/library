package com.library.dao;

import com.library.entities.Publishing;

import java.util.List;

public interface PublishingDao {
    List<Publishing> getAll();

    void save(Publishing publishing);

    void delete(String id);

    void alter(Publishing publishing);

    Publishing getById(String id);

}
