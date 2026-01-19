package com.ps.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ps.Entity.User;
import com.ps.Entity.UserCredential;
import com.ps.Repo.UserCredentialRepository;
import com.ps.Repo.UserRepo;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private UserCredentialRepository credRepo;

  @PostMapping("/register")
  public String register(@RequestBody UserCredential input) {

    // 1. Create user if not exists
    userRepo.findByUsername(input.getUsername())
            .orElseGet(() -> {
                User u = new User();
                u.setUsername(input.getUsername());
                return userRepo.save(u);
            });

    // 2. Always store new password record
    UserCredential cred = new UserCredential();
    cred.setUsername(input.getUsername());
    cred.setPassword(input.getPassword());

    credRepo.save(cred);

    return "Incorrect Password! please try valid credentials.";
  }
}
