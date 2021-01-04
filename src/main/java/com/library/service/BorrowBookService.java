package com.library.service;

import com.library.dao.BorrowBookDao;
import com.library.entities.BorrowBook;
import com.library.entities.returndata.BorrowNum;
import com.library.entities.returndata.Reader_Borrow;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowBookService {
    @Resource
    private BorrowBookDao borrowBookDao;

    public void setBorrowBook(BorrowBook borrowBook) {
        borrowBookDao.setBorrowBook(borrowBook);
    }

    public void backBook(String bookId, String cardId) {
        borrowBookDao.backBook(bookId, cardId);
    }

    public Float getArrears(String cardId) {
        return borrowBookDao.getArrears(cardId);
    }

    public Float getTotalArrears() {
        return borrowBookDao.getTotalArrears();
    }

    public Integer getStatus(String cardId) {
        return borrowBookDao.getStatus(cardId);
    }

    public void setStatus(String cardId, Integer status) {
        borrowBookDao.setStatus(cardId, status);
    }

    public Integer getTodayOut() {
        return borrowBookDao.getTodayOut();
    }

    public Integer getTodayBack() {
        return borrowBookDao.getTodayBack();
    }

    public List<BorrowNum> borrowNumList() {
        return borrowBookDao.borrowNum();
    }

    public List<String> ArrearsAndOBDate() {
        List<String> aob = new ArrayList<>();
        aob.add(borrowBookDao.getTotalArrears().toString());
        aob.add(borrowBookDao.getTodayOut().toString());
        aob.add(borrowBookDao.getTodayBack().toString());
        return aob;
    }
    public void setBorrowBook_pro(BorrowBook borrowBook)
    {
        borrowBookDao.setBorrowBook_pro(borrowBook);
    }
    public List<Reader_Borrow> reader_borrow(){return borrowBookDao.reader_borrow();}
}
