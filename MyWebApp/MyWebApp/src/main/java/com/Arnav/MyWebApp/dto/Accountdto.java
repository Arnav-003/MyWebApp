package com.Arnav.MyWebApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Accountdto {
    private long id;
    private String accountHolderName;
    private double balance;
}
