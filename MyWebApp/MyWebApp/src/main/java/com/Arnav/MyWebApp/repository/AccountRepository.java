package com.Arnav.MyWebApp.repository;

import com.Arnav.MyWebApp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
