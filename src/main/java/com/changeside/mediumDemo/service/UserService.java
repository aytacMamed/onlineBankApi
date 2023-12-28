package com.changeside.mediumDemo.service;

import com.changeside.mediumDemo.model.Account;
import com.changeside.mediumDemo.model.Role;
import com.changeside.mediumDemo.model.User;

import java.util.List;

public interface UserService {
  List<User> getAllUsers();
  User getUserById(Long id);
  void addAccountToUser(Long userId, Account account);
  void disableUserAccount(Long userId, Long accountId);
  void disableUser(Long userId);
  List<Account> getActiveAccounts(Long userId);
}
