package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MentorController {

    @RequestMapping({"/table_task","/tableTask"})
    public String getTableTaskPage(Model model){
        Mentor mike = new Mentor("Mike","Smith",45, Gender.MALE);
        Mentor tom = new Mentor("Tom","Hanks",65, Gender.MALE);
        Mentor ammy = new Mentor("Ammy","Bryan",25, Gender.FEMALE);

        model.addAttribute("mike",mike);
        model.addAttribute("tom",tom);
        model.addAttribute("ammy",ammy);

        return "/task/tableTask";
    }
}
