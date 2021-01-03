package com.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable {
    private String bookId;
    private String id;//出版社id
    private String bookName;
    private String author;
    private String isbn;
    private String classifyNum;
    private Integer price;
    private String introduction;
    private Date publishDate;
}
