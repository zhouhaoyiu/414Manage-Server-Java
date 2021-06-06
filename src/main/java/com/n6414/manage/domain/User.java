package com.n6414.manage.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String trueName;
    private String nickName;
    private String address;
    private String userName;
    private String passWord;
    private int role;
}
