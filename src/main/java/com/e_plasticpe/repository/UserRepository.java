package com.e_plasticpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.e_plasticpe.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
