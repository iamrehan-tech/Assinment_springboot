package com.relationoneToone.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relationoneToone.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

}
