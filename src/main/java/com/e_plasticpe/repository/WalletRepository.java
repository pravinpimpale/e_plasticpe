package com.e_plasticpe.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.e_plasticpe.entity.Wallet;

import jakarta.transaction.Transactional;

public interface WalletRepository extends JpaRepository<Wallet, Long> {

	@Query("SELECT o FROM Wallet o WHERE o.user_id = :userId")
	List<Wallet> getWalletsByUserId(Long userId);

	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR)", nativeQuery = true)
	List<Wallet> getWalletsByUserIdAndToday(Long userId);

	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)", nativeQuery = true)
	List<Wallet> getWalletsByUserIdLastWeek(Long userId);

	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 MONTH)", nativeQuery = true)
	List<Wallet> getWalletsByUserIdLastMonth(Long userId);

	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 YEAR)", nativeQuery = true)
	List<Wallet> getWalletsByUserIdLastYear(Long userId);

	//Get all order and balance
	@Query(value = "SELECT o.user_id, COUNT(*) AS total_orders, SUM(w.balance) AS total_balance FROM orders o LEFT JOIN wallet w ON o.user_id = w.user_id WHERE o.user_id = :userId AND o.p_status = 'Completed' AND o.created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR) GROUP BY o.user_id", nativeQuery = true)
	List<Wallet> getUserWalletsByUserIdAndToday(Long userId);

	@Query(value = "SELECT o.user_id, COUNT(*) AS total_orders, SUM(w.balance) AS total_balance FROM orders o LEFT JOIN wallet w ON o.user_id = w.user_id WHERE o.user_id = :userId AND o.p_status = 'Completed' AND o.created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK) GROUP BY o.user_id", nativeQuery = true)
	List<Wallet> getUserWalletsByUserIdLastWeek(Long userId);

	@Query(value = "SELECT o.user_id, COUNT(*) AS total_orders, SUM(w.balance) AS total_balance FROM orders o LEFT JOIN wallet w ON o.user_id = w.user_id WHERE o.user_id = :userId AND o.p_status = 'Completed' AND o.created_at >= DATE_SUB(NOW(), INTERVAL 1 MONTH) GROUP BY o.user_id", nativeQuery = true)
	List<Wallet> getUserWalletsByUserIdLastMonth(Long userId);

	@Query(value = "SELECT o.user_id, COUNT(*) AS total_orders, SUM(w.balance) AS total_balance FROM orders o LEFT JOIN wallet w ON o.user_id = w.user_id WHERE o.user_id = :userId AND o.p_status = 'Completed' AND o.created_at >= DATE_SUB(NOW(), INTERVAL 1 YEAR) GROUP BY o.user_id", nativeQuery = true)
	List<Wallet> getUserWalletsByUserIdLastYear(Long userId);
	
	//report
//	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR)", nativeQuery = true)
//	List<Wallet> getReportByUserIdAndToday(Long userId);
//
//	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK)", nativeQuery = true)
//	List<Wallet> getReportByUserIdLastWeek(Long userId);
//
//	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 MONTH)", nativeQuery = true)
//	List<Wallet> getReportByUserIdLastMonth(Long userId);
//
//	@Query(value = "SELECT * FROM Wallet WHERE user_id = :userId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 YEAR)", nativeQuery = true)
//	List<Wallet> getReportByUserIdLastYear(Long userId);
	
	@Query(value = "SELECT vendor_id, SUM(balance) as totalBalance FROM wallet WHERE vendor_id = :vendorId AND created_at >= DATE_SUB(NOW(), INTERVAL 24 HOUR) GROUP BY vendor_id", nativeQuery = true)
	Map<String, Object> getTotalBalanceByUserIdAndToday(@Param("vendorId") Long vendorId);

	@Query(value = "SELECT vendor_id, SUM(balance) as totalBalance FROM wallet WHERE vendor_id = :vendorId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 WEEK) GROUP BY vendor_id", nativeQuery = true)
	Map<String, Object> getTotalBalanceByUserIdLastWeek(@Param("vendorId") Long vendorId);

	@Query(value = "SELECT vendor_id, SUM(balance) as totalBalance FROM wallet WHERE vendor_id = :vendorId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 MONTH) GROUP BY vendor_id", nativeQuery = true)
	Map<String, Object> getTotalBalanceByUserIdLastMonth(@Param("vendorId") Long vendorId);

	@Query(value = "SELECT vendor_id, SUM(balance) as totalBalance FROM wallet WHERE vendor_id = :vendorId AND created_at >= DATE_SUB(NOW(), INTERVAL 1 YEAR) GROUP BY vendor_id", nativeQuery = true)
	Map<String, Object> getTotalBalanceByUserIdLastYear(@Param("vendorId") Long vendorId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO wallet (user_id,vendor_id, balance, created_at, updated_at) VALUES (:userId,:vendor_id, :balance, NOW(), NOW()) ", nativeQuery = true)
	Integer createdWalletBalance(@Param("userId") Long userId,@Param("vendor_id") String vendor_id, @Param("balance") BigDecimal balance);



}
