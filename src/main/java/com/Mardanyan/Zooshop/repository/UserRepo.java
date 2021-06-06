package com.Mardanyan.Zooshop.repository;

import com.Mardanyan.Zooshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {User findByUsername(String username);}
