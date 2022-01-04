package com.example.escapefromdarkness.services;

import com.example.escapefromdarkness.repositories.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppplicationUserDetailsService implements UserDetailsService {
  private final AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var account = accountRepository.findById(username);
    if (account.isEmpty()) {
      throw new UsernameNotFoundException(String.format("Username is not found %s", username));
    }
    return new User(account.get().getUsername(), account.get().getPassword(), Collections.emptyList());
  }
}
