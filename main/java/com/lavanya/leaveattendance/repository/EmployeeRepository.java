package com.lavanya.leaveattendance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lavanya.leaveattendance.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

