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
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column
	private String p_name;
	@Column
	private String p_description;
	@Column
	private BigDecimal p_price;
	@Column
	private String user_id;
	@Column
	@CreationTimestamp
	private LocalDateTime  created_at;
	@Column
	@UpdateTimestamp
	private LocalDateTime updated_at;
	
	public Product() {
		
	}

	public Product(long id, String p_name, BigDecimal p_price, String user_id, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		Id = id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.user_id = user_id;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public BigDecimal getP_price() {
		return p_price;
	}

	public void setP_price(BigDecimal p_price) {
		this.p_price = p_price;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "Product [Id=" + Id + ", p_name=" + p_name + ", p_price=" + p_price + ", user_id=" + user_id
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

	

	
	
	
}
