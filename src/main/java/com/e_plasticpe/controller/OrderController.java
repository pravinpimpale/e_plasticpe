package com.e_plasticpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_plasticpe.entity.Order;
import com.e_plasticpe.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long id) {
		Order order = orderService.getOrderById(id);
		if (order == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(order);
	}

	@PostMapping
	public Order createOrder(@RequestBody Order order) {
		return orderService.createOrder(order);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long id, @RequestBody Order orderDetails) {
		Order updatedOrder = orderService.updateOrder(id, orderDetails);
		if (updatedOrder == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedOrder);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable(value = "id") Long id) {
		orderService.deleteOrder(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/user/{userId}")
	public List<Order> getOrdersByUserId(@PathVariable(value = "userId") Long userId) {
		return orderService.getOrdersByUserId(userId);
	}

	@GetMapping("/vendor/{pincode}")
	public List<Order> getOrdersByPincode(@PathVariable(value = "pincode") Long pincode) {
		return orderService.getOrdersByPincode(pincode);
	}

	@GetMapping("/vendor/{user_id}/status/{status}")
	public List<Order> getOrdersByStatus(@PathVariable(value = "user_id") Long userId,
			@PathVariable(value = "status") String status) {
		return orderService.getOrdersByUserIdAndStatus(userId, status);
	}
}
