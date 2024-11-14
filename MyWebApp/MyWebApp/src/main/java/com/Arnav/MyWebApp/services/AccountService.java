package com.Arnav.MyWebApp.services;

import com.Arnav.MyWebApp.dto.Accountdto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    Accountdto createAccount(Accountdto accountdto);

    Accountdto getAccountId(Long Id);
    Accountdto deposit(Long Id,double amount);
    Accountdto withdraw (Long Id,double amount);
    List<Accountdto> getAllAccounts();
    void deleteAccount(Long Id);
}
