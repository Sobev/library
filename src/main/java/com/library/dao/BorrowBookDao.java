package com.library.dao;

import com.library.entities.BorrowBook;
import com.library.entities.returndata.BorrowNum;
import com.library.entities.returndata.Reader_Borrow;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowBookDao {
    void setBorrowBook(BorrowBook borrowBook);

    void setBorrowBook_pro(BorrowBook borrowBook);

    void backBook(@Param("bookid") String bookId, @Param("cardid") String cardId);

    void backBook_pro(@Param("cardid") String cardId);

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

    @Select("SELECT * FROM reader_borrow")
    List<Reader_Borrow> reader_borrow();

    @Select("SELECT borrownum from reader where cardid=#{cardid}")
    Integer canBorrow(String cardId);
}
