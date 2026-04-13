package com.lavanya.leaveattendance.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lavanya.leaveattendance.model.Attendance;
import com.lavanya.leaveattendance.service.AttendanceService;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    // Mark attendance
    @PostMapping("/{employeeId}")
    public Attendance markAttendance(
            @PathVariable Long employeeId,
            @RequestParam String date,
            @RequestParam String status) {

        LocalDate attendanceDate = LocalDate.parse(date);
        return attendanceService.markAttendance(employeeId, attendanceDate, status);
    }

    // Get attendance history
    @GetMapping("/{employeeId}")
    public List<Attendance> getAttendance(@PathVariable Long employeeId) {
        return attendanceService.getAttendanceByEmployee(employeeId);
    }
}

