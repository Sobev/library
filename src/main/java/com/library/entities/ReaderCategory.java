package com.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReaderCategory implements Serializable {
    private Integer readerCategoryId;
    private Integer num;//最大借阅数量
    private Integer borrowDate;//借阅期限
    private Integer keepDate;//续借期限
    private Integer authority;//权限 1 or 2 or 3
}
