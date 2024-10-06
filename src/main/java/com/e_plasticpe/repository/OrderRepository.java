package com.e_plasticpe.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.e_plasticpe.entity.Order;
import com.e_plasticpe.entity.Wallet;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.user_id = :userId")
	List<Order> findByUserId(Long userId);
	
	@Query("SELECT o FROM Order o WHERE o.id = :id AND CAST(o.rating AS integer) > 0")
	List<Order> getRatingByOrderId(@Param("id") Long id);

	@Query("SELECT o FROM Order o WHERE o.pincode = :pincode ORDER BY o.created_at DESC")
	List<Order> getOrdersByPincode(Long pincode);

    @Query("SELECT o FROM Order o WHERE o.user_id = :userId AND o.p_status = :status")
	List<Order> findByUserIdAndStatus(Long userId, String status);

    @Query("SELECT o FROM Order o WHERE o.p_status ='Completed'")
	List<Order> getAllOrdersByStatus();
    
    @Query("SELECT o FROM Order o WHERE o.user_id = :userId AND o.p_status ='Completed'")
	List<Order> getEarningById(Long userId);

    @Query(value = "SELECT * FROM orders WHERE user_id = :user_id AND created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR)", nativeQuery = true)
    List<Order> getOrdersByUserIdAndToday(Long user_id);

    @Query(value = "SELECT * FROM orders WHERE user_id = :user_id AND created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)", nativeQuery = true)
    List<Order> getOrdersByUserIdLastWeek(Long user_id);

    @Query(value = "SELECT * FROM orders WHERE user_id = :user_id AND created_at >= DATE_SUB(NOW(), INTERVAL 1 MONTH)", nativeQuery = true)
    List<Order> getOrdersByUserIdLastMonth(Long user_id);

    @Query(value = "SELECT * FROM orders WHERE user_id = :user_id AND created_at >= DATE_SUB(NOW(), INTERVAL 1 YEAR)", nativeQuery = true)
    List<Order> getOrdersByUserIdLastYear(Long user_id);

    @Query("SELECT SUM(o.gcoinBalance) FROM Order o WHERE o.user_id = :userId")
    Integer getTotalGcoinBalanceByUserId(@Param("userId") Long id);
    
    //report
//    @Query(value = "SELECT COUNT(*) FROM orders WHERE user_id = :user_id AND p_status = 'Completed' AND created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR)", nativeQuery = true)
//    Integer countCompletedOrdersByUserIdAndToday(@Param("user_id") Long userId);
//
//    @Query(value = "SELECT COUNT(*) FROM orders WHERE user_id = :user_id AND p_status = 'Completed' AND created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)", nativeQuery = true)
//    Integer countCompletedOrdersByUserIdLastWeek(@Param("user_id") Long userId);
//
//    @Query(value = "SELECT COUNT(*) FROM orders WHERE user_id = :user_id AND p_status = 'Completed' AND created_at >= DATE_SUB(NOW(), INTERVAL 1 MONTH)", nativeQuery = true)
//    Integer countCompletedOrdersByUserIdLastMonth(@Param("user_id") Long userId);
//
//    @Query(value = "SELECT COUNT(*) FROM orders WHERE user_id = :user_id AND p_status = 'Completed' AND created_at >= DATE_SUB(NOW(), INTERVAL 1 YEAR)", nativeQuery = true)
//    Integer countCompletedOrdersByUserIdLastYear(@Param("user_id") Long userId);

    @Query(value = "SELECT vendor_id, COUNT(*) as totalOrders FROM orders WHERE vendor_id = :vendorId AND p_status = 'Completed' AND updated_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR) GROUP BY vendor_id", nativeQuery = true)
    Map<String, Object> countCompletedOrdersByUserIdAndToday(@Param("vendorId") Long vendorId);

    @Query(value = "SELECT vendor_id, COUNT(*) as totalOrders FROM orders WHERE vendor_id = :vendorId AND p_status = 'Completed' AND updated_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK) GROUP BY vendor_id", nativeQuery = true)
    Map<String, Object> countCompletedOrdersByUserIdLastWeek(@Param("vendorId") Long vendorId);

    @Query(value = "SELECT vendor_id, COUNT(*) as totalOrders FROM orders WHERE vendor_id = :vendorId AND p_status = 'Completed' AND updated_at >= DATE_SUB(NOW(), INTERVAL 1 MONTH) GROUP BY vendor_id", nativeQuery = true)
    Map<String, Object> countCompletedOrdersByUserIdLastMonth(@Param("vendorId") Long vendorId);

    @Query(value = "SELECT vendor_id, COUNT(*) as totalOrders FROM orders WHERE vendor_id = :vendorId AND p_status = 'Completed' AND updated_at >= DATE_SUB(NOW(), INTERVAL 1 YEAR) GROUP BY vendor_id", nativeQuery = true)
    Map<String, Object> countCompletedOrdersByUserIdLastYear(@Param("vendorId") Long vendorId);




}
