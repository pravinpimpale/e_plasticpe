package com.e_plasticpe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.e_plasticpe.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.user_id = :userId")
	List<Order> findByUserId(Long userId);

	@Query("SELECT o FROM Order o WHERE o.pincode = :pincode")
	List<Order> getOrdersByPincode(Long pincode);

    @Query("SELECT o FROM Order o WHERE o.user_id = :userId AND o.p_status = :status")
	List<Order> findByUserIdAndStatus(Long userId, String status);

}
