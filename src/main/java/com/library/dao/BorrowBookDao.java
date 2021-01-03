package com.library.dao;

import com.library.entities.BorrowBook;
import com.library.entities.returndata.BorrowNum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowBookDao {
    void setBorrowBook(BorrowBook borrowBook);

    void backBook(@Param("bookid") String bookId, @Param("cardid") String cardId);

    Float getArrears(String cardId);

    //return total money
    Float getTotalArrears();

    //whether can borrow book
    Integer getStatus(String carId);

    //borrow a book and set it and if this cardId get arrears
    void setStatus(@Param("cardid") String cardId, @Param("status") Integer status);

    //get today's book out
    Integer getTodayOut();

    //get today's book in
    Integer getTodayBack();

    //get recent borrow book num
    List<BorrowNum> borrowNum();

    List<List<?>> procedure(Integer id);

}
