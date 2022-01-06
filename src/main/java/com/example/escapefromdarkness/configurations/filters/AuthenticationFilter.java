package com.example.escapefromdarkness.configurations.filters;

import com.example.escapefromdarkness.configurations.constants.SecurityConstants;
import com.example.escapefromdarkness.models.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.Date;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private AuthenticationManager authenticationManager;

  public AuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest req,
                                              HttpServletResponse res) throws AuthenticationException {
    try {
      Account account = new ObjectMapper().readValue(req.getInputStream(), Account.class);

      return authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(account.getUsername(),
          account.getPassword(), new ArrayList<>())
      );
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
                                          Authentication auth) throws IOException, ServletException {

    Date exp = new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME);
    Key key = Keys.hmacShaKeyFor(SecurityConstants.KEY.getBytes());
    Claims claims = Jwts.claims().setSubject(((User) auth.getPrincipal()).getUsername());
    String token = Jwts.builder().setClaims(claims).signWith(key, SignatureAlgorithm.HS512).setExpiration(exp).compact();
    System.out.println(token);
    // res.addHeader("token", token);

    res.getWriter().write(token);
    res.getWriter().flush();

  }
}
