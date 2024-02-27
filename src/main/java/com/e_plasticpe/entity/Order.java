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
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column
	private String user_id;
	@Column
	private String p_name;
	@Column(nullable = true)
	private String v_name;
	@Column(nullable = true)
	private String v_address;
	@Column(nullable = true)
	private String v_mobile;
	@Column
	private String p_price;
	@Column
	private String p_status;
	@Column
	private String address;
	@Column
	private String pincode;
	@Column
	private String p_weight;
	@Column
	private String pickup_date;
	@Column
	private String pickup_time;
	@Column
	@CreationTimestamp
	private LocalDateTime created_at;
	@Column
	@UpdateTimestamp
	private LocalDateTime updated_at;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long id, String user_id, String p_name, String v_name, String v_address, String v_mobile,
			String p_price, String p_status, String address, String pincode, String p_weight, String pickup_date,
			String pickup_time, LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		Id = id;
		this.user_id = user_id;
		this.p_name = p_name;
		this.v_name = v_name;
		this.v_address = v_address;
		this.v_mobile = v_mobile;
		this.p_price = p_price;
		this.p_status = p_status;
		this.address = address;
		this.pincode = pincode;
		this.p_weight = p_weight;
		this.pickup_date = pickup_date;
		this.pickup_time = pickup_time;
		this.created_at = created_at;
		this.updated_at = updated_at;
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

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public String getV_address() {
		return v_address;
	}

	public void setV_address(String v_address) {
		this.v_address = v_address;
	}

	public String getV_mobile() {
		return v_mobile;
	}

	public void setV_mobile(String v_mobile) {
		this.v_mobile = v_mobile;
	}

	public String getP_price() {
		return p_price;
	}

	public void setP_price(String p_price) {
		this.p_price = p_price;
	}

	public String getP_status() {
		return p_status;
	}

	public void setP_status(String p_status) {
		this.p_status = p_status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getP_weight() {
		return p_weight;
	}

	public void setP_weight(String p_weight) {
		this.p_weight = p_weight;
	}

	public String getPickup_date() {
		return pickup_date;
	}

	public void setPickup_date(String pickup_date) {
		this.pickup_date = pickup_date;
	}

	public String getPickup_time() {
		return pickup_time;
	}

	public void setPickup_time(String pickup_time) {
		this.pickup_time = pickup_time;
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
		return "Order [Id=" + Id + ", user_id=" + user_id + ", p_name=" + p_name + ", v_name=" + v_name + ", v_address="
				+ v_address + ", v_mobile=" + v_mobile + ", p_price=" + p_price + ", p_status=" + p_status
				+ ", address=" + address + ", pincode=" + pincode + ", p_weight=" + p_weight + ", pickup_date="
				+ pickup_date + ", pickup_time=" + pickup_time + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}

	

}
