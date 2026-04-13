package com.lavanya.leaveattendance.service;

import java.time.LocalDate;
import java.util.List;

import com.lavanya.leaveattendance.model.Attendance;

public interface AttendanceService {

    Attendance markAttendance(Long employeeId, LocalDate date, String status);

    List<Attendance> getAttendanceByEmployee(Long employeeId);
}

