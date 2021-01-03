package com.library.service;

import com.library.dao.BookDao;
import com.library.entities.Book;
import com.library.entities.returndata.ClassifyNum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Resource
    BookDao bookDao;

    public List<Book> getFirstTenData() {
        List<Book> books = bookDao.findByClick(0, 10);
        return books;
    }

    public List<Book> getByClick(Integer time) {
        return bookDao.findByClick(time * 10, (time + 1) * 10);
    }

    public Book editBook(Integer bookId) {
        return bookDao.editBook(bookId);
    }

    public void deleteBook(Integer bookId) {
        bookDao.deleteBook(bookId);
    }

    public List<ClassifyNum> getBookECharts() {
        return bookDao.bookClassify();
    }

    public List<Map<String, String>> getAllPublisher() {
        return bookDao.getPublisher();
    }

    public void updateBook(Book book) {
        bookDao.updateBook(Integer.valueOf(book.getBookId()), book);
    }

    public Book getById(String id) {
        return bookDao.getById(id);
    }

    public Book findByName(String bookName) {
        return bookDao.findByName(bookName);
    }

    public void saveBook(Book book) {
        bookDao.AddBook(book);
    }
}
