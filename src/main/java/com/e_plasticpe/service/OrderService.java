package com.e_plasticpe.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
//			existingOrder.setId(orderDetails.getId());
			existingOrder.setP_name(orderDetails.getP_name());
			existingOrder.setUser_id(orderDetails.getUser_id());
			existingOrder.setVendor_id(orderDetails.getVendor_id());
			existingOrder.setP_weight(orderDetails.getP_weight());
			existingOrder.setP_status(orderDetails.getP_status());
			existingOrder.setV_name(orderDetails.getV_name());
			existingOrder.setAddress(orderDetails.getAddress());
			existingOrder.setP_price(orderDetails.getP_price());
			existingOrder.setLandmark(orderDetails.getLandmark());
			existingOrder.setV_address(orderDetails.getV_address());
			existingOrder.setV_mobile(orderDetails.getV_mobile());
			existingOrder.setU_name(orderDetails.getU_name());;
			existingOrder.setPincode(orderDetails.getPincode());
			existingOrder.setQuantity(orderDetails.getQuantity());
			existingOrder.setQty250(orderDetails.getQty250());
			existingOrder.setQty500(orderDetails.getQty500());
			existingOrder.setQty750(orderDetails.getQty750());
			existingOrder.setQty1(orderDetails.getQty1());
			existingOrder.setPickup_date(orderDetails.getPickup_date());
			existingOrder.setPickup_time(orderDetails.getPickup_time());
			if ("Completed".equalsIgnoreCase(orderDetails.getP_status())) {
				existingOrder.setGcoinBalance(10);
			}
			return orderRepository.save(existingOrder);
		}
		return null;
	}
	
	public Order ratingOrder(Long id, Order orderDetails) {
		Order existingOrder = getOrderById(id);
		if (existingOrder != null) {
			existingOrder.setRating(orderDetails.getRating());
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

	public List<Order> getAllOrdersByStatus() {
		return orderRepository.getAllOrdersByStatus();
	}
	
	public List<Order> getEarningById(Long userId) {
		return orderRepository.getEarningById(userId);
	}

	public Map<String, List<Order>> getAllOrdersByReport(Long user_id) {
		System.out.println("vendor_id"+user_id);
		 List<Order> today = orderRepository.getOrdersByUserIdAndToday(user_id);
		    System.out.println("today:" + today);
		    List<Order> week = orderRepository.getOrdersByUserIdLastWeek(user_id);
		    System.out.println("week:" + week);
		    List<Order> month = orderRepository.getOrdersByUserIdLastMonth(user_id);
		    System.out.println("month:" + month);
		    List<Order> year = orderRepository.getOrdersByUserIdLastYear(user_id);
		    System.out.println("year:" + year);
		    
		    Map<String, List<Order>> combinedMap = new LinkedHashMap<>();
		    combinedMap.put("today", today);
		    combinedMap.put("week", week);
		    combinedMap.put("month", month);
		    combinedMap.put("year", year);
		    
		    System.out.println("All Data :" + combinedMap);
		    return combinedMap;
	}
}
