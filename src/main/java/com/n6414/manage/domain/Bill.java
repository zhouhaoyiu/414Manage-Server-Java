package com.n6414.manage.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Bill {
    private Integer id;
    private String event;
    private Integer amount;
    private String eventDate;
    private Integer submitterId;
    private String submitterUserName;
}
