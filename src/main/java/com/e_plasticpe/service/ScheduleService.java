package com.e_plasticpe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e_plasticpe.entity.Schedule;
import com.e_plasticpe.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	public List<Schedule> getAllSchedules() {
		return scheduleRepository.findAll();
	}

	public Schedule getScheduleById(Long id) {
		return scheduleRepository.findById(id).orElse(null);
	}

	public Schedule createSchedule(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	public Schedule updateSchedule(Long id, Schedule scheduleDetails) {
		Schedule schedule = scheduleRepository.findById(id).orElse(null);
		if (schedule != null) {
			// Update schedule details here
			return scheduleRepository.save(schedule);
		}
		return null;
	}

	public void deleteSchedule(Long id) {
		scheduleRepository.deleteById(id);
	}
}
