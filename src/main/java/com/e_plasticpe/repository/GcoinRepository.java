package com.e_plasticpe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.e_plasticpe.entity.Gcoin;

import jakarta.transaction.Transactional;

public interface GcoinRepository extends JpaRepository<Gcoin, Long>{
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO gcoin (user_id, gcoin) VALUES (:userId, :gcoin) "
			+ "ON DUPLICATE KEY UPDATE gcoin = VALUES(gcoin)", nativeQuery = true)
	Integer createdGcoin(@Param("userId") Long userId, @Param("gcoin") Integer gcoin);
	
	@Query("SELECT o FROM Gcoin o WHERE o.user_id = :userId")
	List<Gcoin> findGcoinByUserId(Long userId);

}
