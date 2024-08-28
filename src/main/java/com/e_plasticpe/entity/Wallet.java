package com.e_plasticpe.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column
	private long user_id;
	@Column
	private String vendor_id;
	@Column
	private BigDecimal balance;
	@Column
	@CreationTimestamp
	private LocalDateTime created_at;
	@Column
	@UpdateTimestamp
	private LocalDateTime updated_at;

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	public Wallet(long id, long user_id, String vendor_id, BigDecimal balance, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		Id = id;
		this.user_id = user_id;
		this.vendor_id = vendor_id;
		this.balance = balance;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(String vendor_id) {
		this.vendor_id = vendor_id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "Wallet [Id=" + Id + ", user_id=" + user_id + ", vendor_id=" + vendor_id + ", balance=" + balance
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

	
	

}
