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
	@Column(nullable = true)
	private long user_id;
	@Column(nullable = true)
	private String vendor_id;
	@Column(nullable = true)
	private String p_name;
	@Column(nullable = true)
	private String v_name;
	@Column(nullable = true)
	private String v_address;
	@Column(nullable = true)
	private String v_mobile;
	@Column(nullable = true)
	private String u_mobile;
	@Column(nullable = true)
	private String u_name;
	@Column(nullable = true)
	private String p_price;
	@Column(nullable = true)
	private String p_status;
	@Column(nullable = true)
	private String landmark;
	@Column(nullable = true)
	private String address;
	@Column(nullable = true)
	private String pincode;
	@Column(nullable = true)
	private String p_weight;
	@Column(nullable = true)
	private String pickup_date;
	@Column(nullable = true)
	private String pickup_time;
	@Column(nullable = true)
	private String rating;
	@Column(nullable = true)
	private Number quantity;
	@Column(nullable = true)
	private Integer gcoinBalance;
	@Column(nullable = true)
	private Integer qty250;
	@Column(nullable = true)
	private Integer qty500;
	@Column(nullable = true)
	private Integer qty750;
	@Column(nullable = true)
	private Integer qty1;
	@Column(nullable = true)
	@CreationTimestamp
	private LocalDateTime created_at;
	@Column(nullable = true)
	@UpdateTimestamp
	private LocalDateTime updated_at;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(long id, long user_id, String vendor_id, String p_name, String v_name, String v_address,
			String v_mobile, String u_mobile, String u_name, String p_price, String p_status, String landmark,
			String address, String pincode, String p_weight, String pickup_date, String pickup_time, String rating,
			Number quantity, Integer gcoinBalance, Integer qty250, Integer qty500, Integer qty750, Integer qty1,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		Id = id;
		this.user_id = user_id;
		this.vendor_id = vendor_id;
		this.p_name = p_name;
		this.v_name = v_name;
		this.v_address = v_address;
		this.v_mobile = v_mobile;
		this.u_mobile = u_mobile;
		this.u_name = u_name;
		this.p_price = p_price;
		this.p_status = p_status;
		this.landmark = landmark;
		this.address = address;
		this.pincode = pincode;
		this.p_weight = p_weight;
		this.pickup_date = pickup_date;
		this.pickup_time = pickup_time;
		this.rating = rating;
		this.quantity = quantity;
		this.gcoinBalance = gcoinBalance;
		this.qty250 = qty250;
		this.qty500 = qty500;
		this.qty750 = qty750;
		this.qty1 = qty1;
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

	public String getU_mobile() {
		return u_mobile;
	}

	public void setU_mobile(String u_mobile) {
		this.u_mobile = u_mobile;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
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

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Number getQuantity() {
		return quantity;
	}

	public void setQuantity(Number quantity) {
		this.quantity = quantity;
	}

	public Integer getGcoinBalance() {
		return gcoinBalance;
	}

	public void setGcoinBalance(Integer gcoinBalance) {
		this.gcoinBalance = gcoinBalance;
	}

	public Integer getQty250() {
		return qty250;
	}

	public void setQty250(Integer qty250) {
		this.qty250 = qty250;
	}

	public Integer getQty500() {
		return qty500;
	}

	public void setQty500(Integer qty500) {
		this.qty500 = qty500;
	}

	public Integer getQty750() {
		return qty750;
	}

	public void setQty750(Integer qty750) {
		this.qty750 = qty750;
	}

	public Integer getQty1() {
		return qty1;
	}

	public void setQty1(Integer qty1) {
		this.qty1 = qty1;
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
		return "Order [Id=" + Id + ", user_id=" + user_id + ", vendor_id=" + vendor_id + ", p_name=" + p_name
				+ ", v_name=" + v_name + ", v_address=" + v_address + ", v_mobile=" + v_mobile + ", u_mobile="
				+ u_mobile + ", u_name=" + u_name + ", p_price=" + p_price + ", p_status=" + p_status + ", landmark="
				+ landmark + ", address=" + address + ", pincode=" + pincode + ", p_weight=" + p_weight
				+ ", pickup_date=" + pickup_date + ", pickup_time=" + pickup_time + ", rating=" + rating + ", quantity="
				+ quantity + ", gcoinBalance=" + gcoinBalance + ", qty250=" + qty250 + ", qty500=" + qty500
				+ ", qty750=" + qty750 + ", qty1=" + qty1 + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ "]";
	}

	

	
	

}
