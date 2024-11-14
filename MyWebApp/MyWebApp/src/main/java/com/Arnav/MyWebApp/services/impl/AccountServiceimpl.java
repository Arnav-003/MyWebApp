package com.Arnav.MyWebApp.services.impl;

import com.Arnav.MyWebApp.dto.Accountdto;
import com.Arnav.MyWebApp.entity.Account;
import com.Arnav.MyWebApp.mappar.AccountMapper;
import com.Arnav.MyWebApp.repository.AccountRepository;
import com.Arnav.MyWebApp.services.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceimpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceimpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Accountdto createAccount(Accountdto accountdto){
        Account account = AccountMapper.mapToAccount(accountdto);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public Accountdto getAccountId(Long Id) {

       Account account= accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public Accountdto deposit(Long Id, double amount) {
        Account account= accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double total=    account.getBalance()+amount;
        account.setBalance(total);
        Account saveAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public Accountdto withdraw(Long Id, double amount) {
        Account account= accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        if (account.getBalance() < amount){
            throw  new RuntimeException("Insufficent balance");
        }
        double total= account.getBalance()-amount;
        account.setBalance(total);
        Account saveAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);

    }

    @Override
    public List<Accountdto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
         return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long Id) {
        Account account= accountRepository.findById(Id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        accountRepository.deleteById(Id);
    }

}
