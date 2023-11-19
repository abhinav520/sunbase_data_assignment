package com.abhinav.sunbase.repository;

import com.abhinav.sunbase.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    User findByEmail(String email);
}
