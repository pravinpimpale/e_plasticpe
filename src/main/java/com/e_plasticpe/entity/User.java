package com.e_plasticpe.entity;

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
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String phone;
	@Column
	private String name;
	@Column(unique = true)
	private String email;
	@Column
	private String address;
	@Column
	private String landmark;
	@Column
	private int pincode;
	@Column
	private String role;
	@Column
	private String status;
	@Column
	@CreationTimestamp
	private LocalDateTime  created_at;
	@Column
	@UpdateTimestamp
	private LocalDateTime updated_at;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(long id, String phone, String name, String email, String address, String landmark, int pincode,
			String role, String status, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.id = id;
		this.phone = phone;
		this.name = name;
		this.email = email;
		this.address = address;
		this.landmark = landmark;
		this.pincode = pincode;
		this.role = role;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "User [id=" + id + ", phone=" + phone + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", landmark=" + landmark + ", pincode=" + pincode + ", role=" + role + ", status=" + status
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
	
	
	
	
	
	
}
