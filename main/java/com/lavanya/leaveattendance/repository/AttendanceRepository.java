package com.lavanya.leaveattendance.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lavanya.leaveattendance.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByEmployeeId(Long employeeId);

    boolean existsByEmployeeIdAndDate(Long employeeId, LocalDate date);
}

