package com.kalaiworld.feedback.api.repository;

import com.kalaiworld.feedback.api.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {

    Users findByUserId(String userId);

    List<Users> findAll();
}
