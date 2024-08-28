package com.e_plasticpe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "gcoin")
public class Gcoin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(unique = true)
	private String user_id;
	
	@Column
	private Integer gcoin;

	public Gcoin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gcoin(long id, String user_id, Integer gcoin) {
		super();
		Id = id;
		this.user_id = user_id;
		this.gcoin = gcoin;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getGcoin() {
		return gcoin;
	}

	public void setGcoin(Integer gcoin) {
		this.gcoin = gcoin;
	}

	@Override
	public String toString() {
		return "Gcoin [Id=" + Id + ", user_id=" + user_id + ", gcoin=" + gcoin + "]";
	}

	
	
	
	
	

}
