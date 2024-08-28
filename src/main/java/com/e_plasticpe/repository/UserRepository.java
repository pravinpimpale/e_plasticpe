package com.e_plasticpe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.e_plasticpe.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	@Query("SELECT u FROM User u WHERE u.pincode = :pincode AND u.role = 'vendor'")
    User findVendorByPincode(@Param("pincode") String string);
}
