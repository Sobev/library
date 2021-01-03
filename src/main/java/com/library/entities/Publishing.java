package com.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Publishing implements Serializable {
    private String id;
    private String email;
    private String name;
    private String phone;
    private String location;
    private String place;
}
