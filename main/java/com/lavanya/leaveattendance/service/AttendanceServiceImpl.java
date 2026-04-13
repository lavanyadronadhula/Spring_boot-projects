package com.lavanya.leaveattendance.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lavanya.leaveattendance.model.Attendance;
import com.lavanya.leaveattendance.model.Employee;
import com.lavanya.leaveattendance.repository.AttendanceRepository;
import com.lavanya.leaveattendance.repository.EmployeeRepository;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Attendance markAttendance(Long employeeId, LocalDate date, String status) {

        if (attendanceRepository.existsByEmployeeIdAndDate(employeeId, date)) {
            throw new RuntimeException("Attendance already marked for this date");
        }

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Attendance attendance = new Attendance(date, status, employee);
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByEmployee(Long employeeId) {
        return attendanceRepository.findByEmployeeId(employeeId);
    }
}

