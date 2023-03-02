package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarController {


    @RequestMapping("/info")
    public String carInfo(@RequestParam String make , Model model){
        model.addAttribute("make",make);

        return "/car/car-info";
    }
    @RequestMapping("/info2")
    public String carInfo2(@RequestParam(value = "make", required = false, defaultValue = "KIA") String make , Model model){
        model.addAttribute("make",make);

        return "/car/car-info";
    }
    //localhost:8080/info3?make=Honda&year=2015
    @RequestMapping("/info3")
    public String carInfo3(@RequestParam String make , @RequestParam int year, Model model){
        model.addAttribute("make",make);
        model.addAttribute("year",year);

        return "/car/car-info";
    }
    //localhost:8080/info/honda
    @RequestMapping("/info/{make}/{year}")
    public String getCarInfo(@PathVariable String make, @PathVariable int year){
        //honda
        System.out.println(make);
        System.out.println(year);
        return "car/car-info";
    }
}
