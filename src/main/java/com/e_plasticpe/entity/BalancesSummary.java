package com.e_plasticpe.entity;

import java.math.BigDecimal;

public class BalancesSummary {

	private BigDecimal  todayBalance;
	private BigDecimal  lastWeekBalance;
	private BigDecimal  lastMonthBalance;
	private BigDecimal  lastYearBalance;
	public BalancesSummary() {
		// TODO Auto-generated constructor stub
	}
	public BalancesSummary(BigDecimal todayBalance, BigDecimal lastWeekBalance, BigDecimal lastMonthBalance,
			BigDecimal lastYearBalance) {
		super();
		this.todayBalance = todayBalance;
		this.lastWeekBalance = lastWeekBalance;
		this.lastMonthBalance = lastMonthBalance;
		this.lastYearBalance = lastYearBalance;
	}
	public BigDecimal getTodayBalance() {
		return todayBalance;
	}
	public void setTodayBalance(BigDecimal todayBalance) {
		this.todayBalance = todayBalance;
	}
	public BigDecimal getLastWeekBalance() {
		return lastWeekBalance;
	}
	public void setLastWeekBalance(BigDecimal lastWeekBalance) {
		this.lastWeekBalance = lastWeekBalance;
	}
	public BigDecimal getLastMonthBalance() {
		return lastMonthBalance;
	}
	public void setLastMonthBalance(BigDecimal lastMonthBalance) {
		this.lastMonthBalance = lastMonthBalance;
	}
	public BigDecimal getLastYearBalance() {
		return lastYearBalance;
	}
	public void setLastYearBalance(BigDecimal lastYearBalance) {
		this.lastYearBalance = lastYearBalance;
	}
	@Override
	public String toString() {
		return "BalancesSummary [todayBalance=" + todayBalance + ", lastWeekBalance=" + lastWeekBalance
				+ ", lastMonthBalance=" + lastMonthBalance + ", lastYearBalance=" + lastYearBalance
				+ ", last24HoursBalance=" + "]";
	}
	
	
}
