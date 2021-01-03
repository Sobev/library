package com.library.dao;

import com.library.entities.Book;
import com.library.entities.returndata.ClassifyNum;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface BookDao {

    List<Book> findByClick(@Param("start") Integer start, @Param("end") Integer end);

    @Transactional
    void AddBook(Book book);

    Book editBook(Integer bookId);

    void deleteBook(Integer bookId);

    void updateBook(@Param("bookid") Integer bookId, @Param("obj") Book book);

    //E-charts Info
    //maybe ...
    List<ClassifyNum> bookClassify();

    List<Map<String, String>> getPublisher();

    Book getById(String id);

    Book findByName(String bookName);
}
