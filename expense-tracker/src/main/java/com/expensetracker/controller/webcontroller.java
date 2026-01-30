package com.expensetracker.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.expensetracker.model.Expense;
import com.expensetracker.service.ExpenseService;

@Controller
public class webcontroller {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses/new")
    public String showExpenseForm(Model model) {
        model.addAttribute("expense", new Expense());
        return "add-expense";
    }

    @PostMapping("/expenses")
    public String addExpense(@ModelAttribute Expense expense) {
        expenseService.addExpense(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/expenses")
    public String viewAllExpenses(Model model) {
        model.addAttribute("expenses", expenseService.getAllExpenses());
     // 💰 Get total expense amount
        Double total = expenseService.getTotalExpenseAmount();
        model.addAttribute("totalExpense", total != null ? total : 0.0);
        return "list-expenses";
    }

    @GetMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
    
 // Filter by category
    @GetMapping("/expenses/category")
    public String filterByCategory(@RequestParam String category, Model model) {
        model.addAttribute("expenses", expenseService.getExpensesByCategory(category));
        return "list-expenses";
    }

    // Filter by date range
    @GetMapping("/expenses/dates")
    public String filterByDateRange(@RequestParam String from,
                                    @RequestParam String to,
                                    Model model) {
        LocalDate start = LocalDate.parse(from);
        LocalDate end = LocalDate.parse(to);
        model.addAttribute("expenses", expenseService.getExpensesByDateRange(start, end));
        return "list-expenses";
    }
    
    

    

}
