package com.Arnav.MyWebApp.mappar;

import com.Arnav.MyWebApp.dto.Accountdto;
import com.Arnav.MyWebApp.entity.Account;

public class AccountMapper {
    public static Account mapToAccount(Accountdto accountdto){
        Account account = new Account(
          accountdto.getId(),
          accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );
        return account;
    }
    public static Accountdto mapToAccountDto(Account account){
        Accountdto accountdto =new Accountdto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accountdto;
    }
}
