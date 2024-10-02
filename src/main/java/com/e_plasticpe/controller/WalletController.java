package com.e_plasticpe.controller;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.e_plasticpe.entity.BalancesSummary;
import com.e_plasticpe.entity.Order;
import com.e_plasticpe.entity.User;
import com.e_plasticpe.entity.Wallet;
import com.e_plasticpe.repository.UserRepository;
import com.e_plasticpe.repository.WalletRepository;
import com.e_plasticpe.service.OrderService;
import com.e_plasticpe.service.WalletService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/wallets")
public class WalletController {

	@Autowired
	private WalletService walletService;
	
	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<Wallet> getAllWallets() {
		List<Wallet> array = walletService.getAllWallets();
		System.out.println(array);
		return walletService.getAllWallets();
	}

	@GetMapping("/balances")
	public BalancesSummary getBalancesSummary() {
	    List<Wallet> wallets = walletService.getAllWallets();
	    LocalDate today = LocalDate.now();
	    LocalDateTime now = LocalDateTime.now();

	    LocalDateTime startOfLastWeek = now.minusWeeks(1).with(DayOfWeek.MONDAY).with(LocalTime.MIN);
	    LocalDateTime endOfLastWeek = now.minusWeeks(1).with(DayOfWeek.SUNDAY).with(LocalTime.MAX);

	    LocalDateTime startOfLastMonth = now.minusMonths(1).withDayOfMonth(1).with(LocalTime.MIN);
	    LocalDateTime endOfLastMonth = now.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);

	    LocalDateTime startOfLastYear = now.minusYears(1).withDayOfYear(1).with(LocalTime.MIN);
	    LocalDateTime endOfLastYear = now.minusYears(1).with(TemporalAdjusters.lastDayOfYear()).with(LocalTime.MAX);

	    LocalDateTime startOfLast24Hours = now.minusDays(1).with(LocalTime.MIN);
	    LocalDateTime endOfLast24Hours = now;

	    BigDecimal todayBalance = calculateBalanceForDate(wallets, today);
	    BigDecimal lastWeekBalance = calculateBalanceForDateTimeRange(wallets, startOfLastWeek, endOfLastWeek);
	    BigDecimal lastMonthBalance = calculateBalanceForDateTimeRange(wallets, startOfLastMonth, endOfLastMonth);
	    BigDecimal lastYearBalance = calculateBalanceForDateTimeRange(wallets, startOfLastYear, endOfLastYear);

	    return new BalancesSummary(todayBalance, lastWeekBalance, lastMonthBalance, lastYearBalance);
	}


	private BigDecimal calculateBalanceForDate(List<Wallet> wallets, LocalDate date) {
	    return wallets.stream()
	        .filter(wallet -> wallet.getCreated_at().toLocalDate().equals(date))
	        .map(Wallet::getBalance)
	        .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	private BigDecimal calculateBalanceForDateTimeRange(List<Wallet> wallets, LocalDateTime startDateTime, LocalDateTime endDateTime) {
	    return wallets.stream()
	        .filter(wallet -> {
	            LocalDateTime walletDateTime = wallet.getCreated_at();
	            return !walletDateTime.isBefore(startDateTime) && !walletDateTime.isAfter(endDateTime);
	        })
	        .map(Wallet::getBalance)
	        .reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Wallet> getWalletById(@PathVariable(value = "id") Long id) {
		Wallet wallet = walletService.getWalletById(id);
		if (wallet == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(wallet);
	}

	@PostMapping
	public Wallet createWallet(@RequestBody Wallet wallet) {
		return walletService.createWallet(wallet);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Wallet> updateWallet(@PathVariable(value = "id") Long id, @RequestBody Wallet walletDetails) {
		Wallet updatedWallet = walletService.updateWallet(id, walletDetails);
		if (updatedWallet == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedWallet);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteWallet(@PathVariable(value = "id") Long id) {
		walletService.deleteWallet(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/user/{userId}")
	public Map<String, List<Wallet>> getWalletsByUserId(@PathVariable(value = "userId") Long userId) {
	    return walletService.getWalletsByUserId(userId);
	}
	
	@GetMapping("/user/report/{vendorId}")
	public Map<String, Object> getReportByUserId(@PathVariable(value = "vendorId") Long vendorId) {
	    return walletService.getReportByUserId(vendorId);
	}
	
	@GetMapping("/userWallet/{userId}")
	public Map<String, List<Wallet>> getUserWalletsByUserId(@PathVariable(value = "userId") Long userId) {
	    return walletService.getUserWalletsByUserId(userId);
	}
}
