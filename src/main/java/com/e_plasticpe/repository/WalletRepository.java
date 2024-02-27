package com.e_plasticpe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.e_plasticpe.entity.Wallet;

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

}
