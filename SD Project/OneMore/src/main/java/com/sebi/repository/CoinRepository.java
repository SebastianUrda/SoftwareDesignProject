package com.sebi.repository;

import com.sebi.entity.Coin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinRepository extends CrudRepository<Coin,Integer> {
    public List<Coin> findByOwner_UserName(String userName);
}