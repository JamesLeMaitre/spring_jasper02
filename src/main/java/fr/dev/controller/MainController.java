package fr.dev.controller;

import fr.dev.dao.PersonneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private PersonneServiceImpl personneService;

    @GetMapping("/home")
    public String home(){
        return "index";
    }
}
