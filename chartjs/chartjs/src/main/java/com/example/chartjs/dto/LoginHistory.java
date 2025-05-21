package com.example.chartjs.dto;

import lombok.Data;
import java.util.Date;

@Data
public class LoginHistory {
    private int no;
    private String id;
    private Date logindate;
}