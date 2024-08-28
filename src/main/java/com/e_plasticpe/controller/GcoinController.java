package com.e_plasticpe.controller;

import java.util.List;

import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e_plasticpe.entity.Gcoin;
import com.e_plasticpe.service.GcoinService;

@RestController
@RequestMapping("/api/gcoin")
public class GcoinController {

	@Autowired
	private GcoinService gcoinService;
	
	@GetMapping("/{user_id}")
	public ResponseEntity<List<Gcoin>> getGcoin(@PathVariable(value = "user_id") Long id) {
		List<Gcoin> gcoin = gcoinService.getGcoinById(id);
		if (gcoin == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(gcoin);
		
	}

}
