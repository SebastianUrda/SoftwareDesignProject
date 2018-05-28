package com.sebi.service;

import com.sebi.entity.*;
import com.sebi.dto.TransactionDto;
import com.sebi.entity.Transaction;
import com.sebi.repository.CoinRepository;
import com.sebi.repository.PersonRepository;
import com.sebi.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class TransactionService {
    @Autowired
    private CoinRepository coinRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactions()
    {
        List<Transaction> coins=new ArrayList<>();
        transactionRepository.findAll().forEach(coins::add);
        return coins;
    }

    public void addTransaction(TransactionDto transactionDto)
    {
        System.out.println("Seller Name "+transactionDto.getSellerName());
        Person seller= personRepository.findByUserName(transactionDto.getSellerName());
        Person buyer=personRepository.findByUserName(transactionDto.getBuyerName());
        Coin coin=coinRepository.findOne(transactionDto.getCoinId());
        Transaction transaction= new Transaction(seller,buyer,coin);
        transactionRepository.save(transaction);
        coin.setOwner(buyer);
        coinRepository.save(coin);
    }


}
