package com.saloonManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saloonManagement.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
