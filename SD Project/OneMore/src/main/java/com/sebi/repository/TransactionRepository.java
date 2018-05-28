package com.sebi.repository;


import com.sebi.entity.Transaction;
import org.springframework.data.repository.CrudRepository;


public interface TransactionRepository extends CrudRepository<Transaction,Integer> {

}
