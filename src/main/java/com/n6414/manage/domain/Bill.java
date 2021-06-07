package com.n6414.manage.domain;


import lombok.Data;

@Data
public class Bill {
    private Integer id;
    private String event;
    private Integer amount;
    private Integer amountCode;
    private String eventDate;
    private Integer submitterId;
    private String submitterTrueName;
    private String submitterUserName;
}