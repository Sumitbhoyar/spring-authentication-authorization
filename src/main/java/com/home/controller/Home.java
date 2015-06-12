package com.home.controller;

import com.home.view.bean.LoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class Home{
    @Autowired
    private LoggedInUser loggedInUser;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        model.addAttribute("loggedInUser", loggedInUser);
		//new comment
        return "home";
    }

    @RequestMapping(value="/login")
    public String login(){
        return "auth/login";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value="/ceo")
    public String ceo(){
        return "ceo";
    }

    @RequestMapping(value="/logout")
    public String logout(){
        return "auth/logout";
    }

    @RequestMapping(value="/denied")
    public String denied(){
        return "auth/denied";
    }
}
