package com.e_plasticpe.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_plasticpe.entity.Order;
import com.e_plasticpe.entity.User;
import com.e_plasticpe.entity.Wallet;
import com.e_plasticpe.repository.UserRepository;
import com.e_plasticpe.repository.WalletRepository;
import com.e_plasticpe.service.OrderService;
import com.e_plasticpe.service.WalletService;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WalletService walletService;
	
	@Autowired
	private WalletRepository walletRepository;

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
		 // Find vendor by pincode
        User vendor = userRepository.findVendorByPincode(order.getPincode());
        if (vendor != null) {
            // Set vendor details to the order
            order.setV_name(vendor.getName());
            order.setV_address(vendor.getAddress());
            order.setV_mobile(vendor.getPhone());
        }else {
        	throw new IllegalArgumentException("Service not available for your pincode");
        }
		return orderService.createOrder(order);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateOrder(@PathVariable(value = "id") Long id, @RequestBody Order orderDetails) {
	    Order updatedOrder = orderService.updateOrder(id, orderDetails);
	    
	    if (updatedOrder == null) {
	        return ResponseEntity.notFound().build();
	    }

	    if ("Completed".equalsIgnoreCase(updatedOrder.getP_status())) {
	        System.out.println(orderDetails.getP_status());
	        createdWalletBalance(orderDetails.getUser_id(),orderDetails.getVendor_id(),new BigDecimal(orderDetails.getP_price()));
	    }

	    return ResponseEntity.ok(updatedOrder);
	}
	
	@Transactional
	public Integer createdWalletBalance(long user_id,String vendor_id, BigDecimal balance) {
		return walletRepository.createdWalletBalance(user_id,vendor_id, balance);
	}

	
	@PutMapping("/rating/{id}")
	public ResponseEntity<Order> ratingOrder(@PathVariable(value = "id") Long id, @RequestBody Order orderDetails) {
		Order updatedOrder = orderService.ratingOrder(id, orderDetails);
		if (updatedOrder == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedOrder);
	}
	
	@GetMapping("/rating/{id}")
	public List<Order> getRatingByUserId(@PathVariable(value = "id") Long id) {
		return orderService.getRatingByOrderId(id);
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
	
	@GetMapping("/earning")
	public List<Order> getAllOrdersByStatus() {
		return orderService.getAllOrdersByStatus();
	}
	
	
	@GetMapping("/earning/{user_id}")
	public Map<String, Object> getEarningById(@PathVariable(value = "user_id") Long userId) {
	    List<Order> orders = orderService.getEarningById(userId);
	    double totalPrice = 0.0;

	    for (Order item : orders) {
	        totalPrice += Double.parseDouble(item.getP_price());
	    }

	    // Create a response object containing the total price and the list of orders
	    Map<String, Object> response = new HashMap<>();
	    response.put("user_id", userId);
	    response.put("totalEarning", totalPrice);

	    return response;
	}

	
	@GetMapping("/report/{user_id}")
	public Map<String, List<Order>> getAllOrdersByReport(@PathVariable(value = "user_id") Long user_id) {
		return orderService.getAllOrdersByReport(user_id);
	}
}
