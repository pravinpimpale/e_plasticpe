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
@Table(name="schedule")
public class Schedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	@Column
	private long user_id;
	@Column
	private String product_id;
	@Column
	private LocalDateTime schedule_time;
	@Column
	@CreationTimestamp
	private LocalDateTime  created_at;
	@Column
	@UpdateTimestamp
	private LocalDateTime updated_at;
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	public Schedule(long id, long user_id, String product_id, LocalDateTime schedule_time, LocalDateTime created_at,
			LocalDateTime updated_at) {
		super();
		Id = id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.schedule_time = schedule_time;
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
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public LocalDateTime getSchedule_time() {
		return schedule_time;
	}
	public void setSchedule_time(LocalDateTime schedule_time) {
		this.schedule_time = schedule_time;
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
		return "Schedule [Id=" + Id + ", user_id=" + user_id + ", product_id=" + product_id + ", schedule_time="
				+ schedule_time + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
	
}
