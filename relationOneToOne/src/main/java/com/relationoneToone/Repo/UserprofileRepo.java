package com.relationoneToone.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.relationoneToone.model.Userprofile;

@Repository
public interface UserprofileRepo extends JpaRepository<Userprofile,Long> {

}
