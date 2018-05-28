package com.sebi.service;
import com.sebi.entity.Coin;
import com.sebi.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoinService {
    @Autowired
    private CoinRepository coinRepository;

    public List<Coin> getMyCoins(String userName)
    {
        return coinRepository.findByOwner_UserName(userName);
    }
    public void addCoin(Coin coin) {
        coinRepository.save(coin);
    }
    public List<Coin> getAllCoins()
    {
        List<Coin> coins=new ArrayList<>();
        coinRepository.findAll().forEach(coins::add);
        return coins;
    }
}
