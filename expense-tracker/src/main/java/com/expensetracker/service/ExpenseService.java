package com.expensetracker.service;

import java.time.LocalDate;
import java.util.List;

import com.expensetracker.model.Expense;

public interface ExpenseService {
	Expense addExpense(Expense expense);
	
	List<Expense> getAllExpenses();
	
	Expense getExpenseById(Long id);

    Expense updateExpense(Long id, Expense expense);

    List<Expense> getExpensesByCategory(String category);

    List<Expense> getExpensesByDateRange(LocalDate from, LocalDate to);
    
    Double getTotalExpenseAmount();


    void deleteExpense(Long id);

}
