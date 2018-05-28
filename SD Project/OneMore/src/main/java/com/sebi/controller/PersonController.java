package com.sebi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.sebi.service.PersonService;
import org.springframework.web.servlet.ModelAndView;
import com.sebi.entity.Person;
import java.util.Arrays;
import java.util.List;
import org.springframework.ui.Model;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ModelAndView getUsers() {
        List<Person> userList = personService.getAllPersons();

        ModelAndView modelAndView = new ModelAndView("persons");

        modelAndView.addObject("userList", userList);
        return modelAndView;
    }
    @PostMapping("/createPerson")
    public ModelAndView createUser(@ModelAttribute Person userDto1) {
        personService.addPerson(userDto1);
        List<Person> userDtoList = personService.getAllPersons();

        ModelAndView mav = new ModelAndView("persons");

        mav.addObject("userList", userDtoList);

        return mav;
    }
    @GetMapping("/addPersonForm")
    public String createUserForm(Model model) {
        model.addAttribute("user", new Person());
        return "addPersonForm";
    }
    @GetMapping("/registerForm")
    public String registerUserForm(Model model) {
        model.addAttribute("user", new Person());

        return "registerForm";
    }
    @PostMapping("/register")
    public void registerUser(@ModelAttribute Person userDto1) {
        userDto1.setRole("USER");
        personService.addPerson(userDto1);
    }


}
