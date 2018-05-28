package com.sebi.controller;

import com.sebi.entity.Coin;
import com.sebi.service.CoinService;
import com.sebi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
@Controller
public class CoinController {
    @Autowired
    private CoinService coinService;

    @Autowired
    private PersonService personService;

    @GetMapping("/coins")
    public ModelAndView getMyCoins() {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername(); //get logged in username
        List<Coin> coinsList = coinService.getMyCoins(name);

        ModelAndView modelAndView = new ModelAndView("coins");

        modelAndView.addObject("coinsList", coinsList);
        return modelAndView;
    }
    @GetMapping("/AllCoins")
    public ModelAndView getAllCoins() {
        List<Coin> coinsList = coinService.getAllCoins();
        ModelAndView modelAndView = new ModelAndView("coins");
        modelAndView.addObject("coinsList", coinsList);
        return modelAndView;
    }
    @PostMapping("/addCoin")
    public ModelAndView addCoin(@ModelAttribute Coin coin) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = user.getUsername();
        coin.setOwner(personService.findByName(name));
        coinService.addCoin(coin);
        List<Coin> userDtoList = coinService.getAllCoins();

        ModelAndView mav = new ModelAndView("coins");

        mav.addObject("coinsList", userDtoList);

        return mav;
    }
    @GetMapping("/addCoinForm")
    public String createUserForm(Model model) {
        model.addAttribute("coin", new Coin());
        return "addCoinForm";
    }
}
