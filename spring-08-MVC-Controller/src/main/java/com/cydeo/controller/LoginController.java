package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //register controller in Handler Mapping
public class LoginController {

    @RequestMapping("/login") //set end point
    public String getLoginPage(){
        return "login.html";
    }
}
