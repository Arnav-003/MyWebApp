package com.Arnav.MyWebApp.controller;

import com.Arnav.MyWebApp.dto.Accountdto;
import com.Arnav.MyWebApp.services.AccountService;
import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountController  {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    @PostMapping
    public ResponseEntity<Accountdto> addAccount(@RequestBody Accountdto accountdto){
        return new ResponseEntity<>(accountService.createAccount(accountdto), HttpStatus.CREATED);

    }
    @GetMapping("/{id}")

    public ResponseEntity<Accountdto> getAccountId(@PathVariable Long id){
        Accountdto accountdto=accountService.getAccountId(id);
        return  ResponseEntity.ok(accountdto);
    }
    @PostMapping("/{id}/deposit")
    public ResponseEntity<Accountdto> deposit(@PathVariable Long id,@RequestBody Map<String, Double> request){
       double amount = request.get("amount");
        Accountdto accountdto= accountService.deposit(id,amount);
        return ResponseEntity.ok(accountdto);
    }
    @PostMapping("/{id}/withdraw")
    public ResponseEntity<Accountdto> withdraw(@PathVariable Long id,@RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        Accountdto accountdto= accountService.withdraw( id,amount);
        return ResponseEntity.ok(accountdto);
    }
    @GetMapping
    public ResponseEntity<List<Accountdto>> getAllAccount(){
        List<Accountdto> accountdtos= accountService.getAllAccounts();
        return ResponseEntity.ok(accountdtos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccountId(@PathVariable Long id){
        accountService.deleteAccount(id);
        return  ResponseEntity.ok("Account deleted sucessfully");
    }

}
