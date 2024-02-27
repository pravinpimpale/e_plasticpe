package com.e_plasticpe.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_plasticpe.entity.Order;
import com.e_plasticpe.entity.Wallet;
import com.e_plasticpe.repository.WalletRepository;

@Service
public class WalletService {

	@Autowired
	private WalletRepository walletRepository;

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

}
