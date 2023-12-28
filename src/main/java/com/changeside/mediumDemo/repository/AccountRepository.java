package com.changeside.mediumDemo.repository;

import com.changeside.mediumDemo.model.Account;
import com.changeside.mediumDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query("select a from accounts a where a.user.id = :userId and a.is_active = true")
    List<Account> findAccountByUserId(@Param("userId") Long userId);
}
