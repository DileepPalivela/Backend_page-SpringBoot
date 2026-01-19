package com.ps.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps.Entity.UserCredential;

public interface UserCredentialRepository extends JpaRepository<UserCredential, Long> {
}
