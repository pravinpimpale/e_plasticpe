package com.e_plasticpe.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_plasticpe.entity.Order;
import com.e_plasticpe.entity.Wallet;
import com.e_plasticpe.repository.OrderRepository;
import com.e_plasticpe.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	public List<Wallet> getAllWallets() {
		return walletRepository.findAll();
	}

	public Wallet getWalletById(Long id) {
		return walletRepository.findById(id).orElse(null);
	}

	public Wallet createWallet(Wallet wallet) {
		return walletRepository.save(wallet);
	}

	public Wallet updateWallet(Long id, Wallet walletDetails) {
		Wallet wallet = walletRepository.findById(id).orElse(null);
		if (wallet != null) {
			// Update wallet details here
			return walletRepository.save(wallet);
		}
		return null;
	}

	public void deleteWallet(Long id) {
		walletRepository.deleteById(id);
	}

	public Map<String, List<Wallet>> getWalletsByUserId(Long userId) {
	    List<Wallet> today = walletRepository.getWalletsByUserIdAndToday(userId);
	    System.out.println("today:" + today);
	    List<Wallet> week = walletRepository.getWalletsByUserIdLastWeek(userId);
	    System.out.println("week:" + week);
	    List<Wallet> month = walletRepository.getWalletsByUserIdLastMonth(userId);
	    System.out.println("month:" + month);
	    List<Wallet> year = walletRepository.getWalletsByUserIdLastYear(userId);
	    System.out.println("year:" + year);
	    
	    Map<String, List<Wallet>> combinedMap = new LinkedHashMap<>();
	    combinedMap.put("today", today);
	    combinedMap.put("week", week);
	    combinedMap.put("month", month);
	    combinedMap.put("year", year);
	    
	    System.out.println("All Data :" + combinedMap);
	    return combinedMap;
	}
	
//	public Map<String, Object> getReportByUserId(Long userId) {
//	    List<Wallet> today = walletRepository.getReportByUserIdAndToday(userId);
//	    System.out.println("today:" + today);
//	    List<Wallet> week = walletRepository.getReportByUserIdLastWeek(userId);
//	    System.out.println("week:" + week);
//	    List<Wallet> month = walletRepository.getReportByUserIdLastMonth(userId);
//	    System.out.println("month:" + month);
//	    List<Wallet> year = walletRepository.getReportByUserIdLastYear(userId);
//	    System.out.println("year:" + year);
//	    
//	    Integer todayOrder = orderRepository.countCompletedOrdersByUserIdAndToday(userId);
//	    Integer weekOrder = orderRepository.countCompletedOrdersByUserIdLastWeek(userId);
//	    Integer monthOrder = orderRepository.countCompletedOrdersByUserIdLastMonth(userId);
//	    Integer yearOrder = orderRepository.countCompletedOrdersByUserIdLastYear(userId);
//	    
//	    Map<String, Object> combinedMap = new LinkedHashMap<>();
//	    combinedMap.put("today", today);
//	    combinedMap.put("week", week);
//	    combinedMap.put("month", month);
//	    combinedMap.put("year", year);
//	    combinedMap.put("todayOrder", todayOrder);
//	    combinedMap.put("weekOrder", weekOrder);
//	    combinedMap.put("monthOrder", monthOrder);
//	    combinedMap.put("yearOrder", yearOrder);
//	    
//	    System.out.println("All Data :" + combinedMap);
//	    return combinedMap;
//	}
	
	public Map<String, Object> getReportByUserId(Long vendor_id) {
	    Map<String, Object> combinedMap = new LinkedHashMap<>();

	    try {
	        // Today's report
	        Map<String, Object> todayBalance = walletRepository.getTotalBalanceByUserIdAndToday(vendor_id);
	        Map<String, Object> todayOrders = orderRepository.countCompletedOrdersByUserIdAndToday(vendor_id);

	        combinedMap.put("today", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", todayBalance != null ? todayBalance.getOrDefault("totalBalance", 0) : 0,
	            "totalOrders", todayOrders != null ? todayOrders.getOrDefault("totalOrders", 0) : 0
	        ));
	    } catch (Exception e) {
	        combinedMap.put("today", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", 0,
	            "totalOrders", 0,
	            "error", "Error retrieving today's report"
	        ));
	        e.printStackTrace();
	    }

	    try {
	        // Last week's report including yesterday
	        Map<String, Object> weekBalance = walletRepository.getTotalBalanceByUserIdLastWeek(vendor_id);
	        Map<String, Object> weekOrders = orderRepository.countCompletedOrdersByUserIdLastWeek(vendor_id);

	        combinedMap.put("week", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", weekBalance != null ? weekBalance.getOrDefault("totalBalance", 0) : 0,
	            "totalOrders", weekOrders != null ? weekOrders.getOrDefault("totalOrders", 0) : 0
	        ));
	    } catch (Exception e) {
	        combinedMap.put("week", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", 0,
	            "totalOrders", 0,
	            "error", "Error retrieving last week's report"
	        ));
	        e.printStackTrace();
	    }

	    try {
	        // Last month's report
	        Map<String, Object> monthBalance = walletRepository.getTotalBalanceByUserIdLastMonth(vendor_id);
	        Map<String, Object> monthOrders = orderRepository.countCompletedOrdersByUserIdLastMonth(vendor_id);

	        combinedMap.put("month", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", monthBalance != null ? monthBalance.getOrDefault("totalBalance", 0) : 0,
	            "totalOrders", monthOrders != null ? monthOrders.getOrDefault("totalOrders", 0) : 0
	        ));
	    } catch (Exception e) {
	        combinedMap.put("month", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", 0,
	            "totalOrders", 0,
	            "error", "Error retrieving last month's report"
	        ));
	        e.printStackTrace();
	    }

	    try {
	        // Last year's report
	        Map<String, Object> yearBalance = walletRepository.getTotalBalanceByUserIdLastYear(vendor_id);
	        Map<String, Object> yearOrders = orderRepository.countCompletedOrdersByUserIdLastYear(vendor_id);

	        combinedMap.put("year", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", yearBalance != null ? yearBalance.getOrDefault("totalBalance", 0) : 0,
	            "totalOrders", yearOrders != null ? yearOrders.getOrDefault("totalOrders", 0) : 0
	        ));
	    } catch (Exception e) {
	        combinedMap.put("year", Map.of(
	            "vendor_id", vendor_id,
	            "totalBalance", 0,
	            "totalOrders", 0,
	            "error", "Error retrieving last year's report"
	        ));
	        e.printStackTrace();
	    }

	    return combinedMap;
	}



	
	
	public Map<String, List<Wallet>> getReportUserId(Long userId) {
	    List<Wallet> today = walletRepository.getWalletsByUserIdAndToday(userId);
	    System.out.println("today:" + today);
	    List<Wallet> week = walletRepository.getWalletsByUserIdLastWeek(userId);
	    System.out.println("week:" + week);
	    List<Wallet> month = walletRepository.getWalletsByUserIdLastMonth(userId);
	    System.out.println("month:" + month);
	    List<Wallet> year = walletRepository.getWalletsByUserIdLastYear(userId);
	    System.out.println("year:" + year);
	    
	    Map<String, List<Wallet>> combinedMap = new LinkedHashMap<>();
	    combinedMap.put("today", today);
	    combinedMap.put("week", week);
	    combinedMap.put("month", month);
	    combinedMap.put("year", year);
	    
	    System.out.println("All Data :" + combinedMap);
	    return combinedMap;
	}


	public Map<String, List<Wallet>> getUserWalletsByUserId(Long userId) {
		 List<Wallet> today = walletRepository.getUserWalletsByUserIdAndToday(userId);
		    System.out.println("today:" + today);
		    List<Wallet> week = walletRepository.getUserWalletsByUserIdLastWeek(userId);
		    System.out.println("week:" + week);
		    List<Wallet> month = walletRepository.getUserWalletsByUserIdLastMonth(userId);
		    System.out.println("month:" + month);
		    List<Wallet> year = walletRepository.getUserWalletsByUserIdLastYear(userId);
		    System.out.println("year:" + year);
		    
		    Map<String, List<Wallet>> combinedMap = new LinkedHashMap<>();
		    combinedMap.put("today", today);
		    combinedMap.put("week", week);
		    combinedMap.put("month", month);
		    combinedMap.put("year", year);
		    
		    System.out.println("All Data :" + combinedMap);
		    return combinedMap;
	}	

}
