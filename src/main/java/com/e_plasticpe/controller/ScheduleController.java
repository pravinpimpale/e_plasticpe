package com.e_plasticpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.e_plasticpe.entity.Schedule;
import com.e_plasticpe.entity.User;
import com.e_plasticpe.repository.ScheduleRepository;
import com.e_plasticpe.repository.UserRepository;
import com.e_plasticpe.service.ScheduleService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/schedules")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@GetMapping
	public List<Schedule> getAllSchedules() {
		return scheduleService.getAllSchedules();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Schedule> getScheduleById(@PathVariable(value = "id") Long id) {
		Schedule schedule = scheduleService.getScheduleById(id);
		if (schedule == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(schedule);
	}

	@PostMapping
	public Schedule createSchedule(@RequestBody Schedule schedule) {
		return scheduleService.createSchedule(schedule);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Schedule> updateSchedule(@PathVariable(value = "id") Long id,
			@RequestBody Schedule scheduleDetails) {
		Schedule updatedSchedule = scheduleService.updateSchedule(id, scheduleDetails);
		if (updatedSchedule == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedSchedule);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSchedule(@PathVariable(value = "id") Long id) {
		scheduleService.deleteSchedule(id);
		return ResponseEntity.ok().build();
	}
}
