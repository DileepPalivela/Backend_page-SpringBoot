package com.ps.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
	  Optional<User> findByUsername(String username);
	}
