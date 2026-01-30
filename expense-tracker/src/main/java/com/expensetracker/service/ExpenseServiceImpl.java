package com.expensetracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepository;



@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	@Override
	public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Expense existing = expenseRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setTitle(expense.getTitle());
            existing.setAmount(expense.getAmount());
            existing.setCategory(expense.getCategory());
            existing.setDate(expense.getDate());
            return expenseRepository.save(existing);
        }
        return null;
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
     
    @Override
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategoryIgnoreCase(category);
    }
    
    @Override
    public List<Expense> getExpensesByDateRange(LocalDate from, LocalDate to) {
        return expenseRepository.findByDateBetween(from, to);
    }
    
    @Override
    public Double getTotalExpenseAmount() {
        Double total = expenseRepository.getTotalExpenseAmount();
        return total != null ? total : 0.0;
    }

      
}
