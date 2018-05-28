package com.sebi.controller;


import com.sebi.dto.TransactionDto;
import com.sebi.entity.Transaction;
import com.sebi.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import com.sebi.service.PersonService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PersonService personService;

    @GetMapping("/AllTransactions")
    public ModelAndView getAllCoins() {
        List<Transaction> transactionList = transactionService.getAllTransactions();
        ModelAndView modelAndView = new ModelAndView("transactions");
        modelAndView.addObject("transactionList", transactionList);
        return modelAndView;
    }
    @GetMapping("/addTransactionForm")
    public String createUserForm(Model model) {
        model.addAttribute("transaction", new TransactionDto());
        return "addTransactionForm";
    }
    @PostMapping("/createTransactionForm")
    public void registerUser(@ModelAttribute TransactionDto userDto1) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        userDto1.setSellerName(name);
        System.out.println("Seller Name "+userDto1.getSellerName());
        transactionService.addTransaction(userDto1);
    }

}
