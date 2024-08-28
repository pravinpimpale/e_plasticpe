package com.e_plasticpe.entity;

import java.math.BigDecimal;

public class UserWalletSummary {

	private Long userId;
    private Long totalOrders;
    private BigDecimal totalBalance;
    
	public UserWalletSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserWalletSummary(Long userId, Long totalOrders, BigDecimal totalBalance) {
		super();
		this.userId = userId;
		this.totalOrders = totalOrders;
		this.totalBalance = totalBalance;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTotalOrders() {
		return totalOrders;
	}

	public void setTotalOrders(Long totalOrders) {
		this.totalOrders = totalOrders;
	}

	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "UserWalletSummary [userId=" + userId + ", totalOrders=" + totalOrders + ", totalBalance=" + totalBalance
				+ "]";
	}

	
	
    
}
