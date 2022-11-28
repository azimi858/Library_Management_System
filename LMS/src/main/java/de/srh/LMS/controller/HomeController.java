package de.srh.LMS.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(path="/")
    public String home() {
        return "home";
    }

    @RequestMapping(path="/login")
    public String login() {
        return "login";
    }

    @RequestMapping(path="/register")
    public String register() {
        return "register";
    }

}