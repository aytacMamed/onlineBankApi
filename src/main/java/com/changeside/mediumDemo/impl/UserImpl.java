package com.changeside.mediumDemo.impl;

import com.changeside.mediumDemo.model.Account;
import com.changeside.mediumDemo.model.User;
import com.changeside.mediumDemo.repository.AccountRepository;
import com.changeside.mediumDemo.repository.UserRepository;
import com.changeside.mediumDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserImpl implements UserService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addAccountToUser(Long userId, Account account) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            account.setUser(user);
            accountRepository.save(account);
        }else {
            throw new IllegalStateException("The account with ID " + account.getId() + " already belongs to another user.");
        }
        }

    @Override
    public void disableUserAccount(Long userId, Long accountId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            Account account=accountRepository.findById(accountId).orElse(null);
            if (account!=null){
                account.set_active(false);
                accountRepository.save(account);
            }else {
                throw new IllegalArgumentException("Account with ID " + accountId + " not found.");
            }
        }else {
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }
    }

    @Override
    public void disableUser(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            user.setIsActive(false);
            userRepository.save(user);
        }
        else {
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }
    }

    @Override
    public List<Account> getActiveAccounts(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            return accountRepository.findAccountByUserId(userId);
        }else {
            throw new IllegalArgumentException("User with ID " + userId + " not found.");
        }

    }
}
