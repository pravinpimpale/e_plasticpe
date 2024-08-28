package com.e_plasticpe.service;


import java.util.List;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.e_plasticpe.entity.Gcoin;
import com.e_plasticpe.repository.GcoinRepository;
import com.e_plasticpe.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class GcoinService {
	
	@Autowired
	private GcoinRepository gcoinRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	Integer gcoin;
	Long id;
	
	public List<Gcoin> getGcoinById(Long id) {
	    gcoin = orderRepository.getTotalGcoinBalanceByUserId(id);
	    this.id =id;
	    createdGcoin();
		return gcoinRepository.findGcoinByUserId(id);
	}
	
	@Transactional
	public Integer createdGcoin() {
		return gcoinRepository.createdGcoin(id,gcoin);
	}
	
}
