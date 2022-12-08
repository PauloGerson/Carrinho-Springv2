package com.example.associacao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Transactional
@Controller
public class LoginController {
    @GetMapping("/login")
   public String form(){
        return "auteticacao/login";
    }

    @GetMapping("/home")
        public String home(){
            return "/";
        }

}
