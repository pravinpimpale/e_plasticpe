package com.e_plasticpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_plasticpe.entity.Order;
import com.e_plasticpe.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order updateOrder(Long id, Order orderDetails) {
		Order existingOrder = getOrderById(id);
		if (existingOrder != null) {
			existingOrder.setId(orderDetails.getId());
			existingOrder.setP_name(orderDetails.getP_name());
			existingOrder.setP_weight(orderDetails.getP_weight());
			existingOrder.setPickup_date(orderDetails.getPickup_date());
			existingOrder.setPickup_time(orderDetails.getPickup_time());
			return orderRepository.save(existingOrder);
		}
		return null;
	}

	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
	}

	public List<Order> getOrdersByUserId(Long userId) {
		return orderRepository.findByUserId(userId);
	}

	public List<Order> getOrdersByPincode(Long pincode) {
		return orderRepository.getOrdersByPincode(pincode);
	}

	public List<Order> getOrdersByUserIdAndStatus(Long userId, String status) {
		System.out.println("data"+userId+status);
		return orderRepository.findByUserIdAndStatus(userId, status);
	}
}
