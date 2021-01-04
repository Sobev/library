package com.library.entities.returndata;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Reader_Borrow implements Serializable {
    private Date outdate;
    private String cardid;
    private String email;
    private String phone;
    private String bookid;
}
