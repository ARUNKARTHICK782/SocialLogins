package com.example.GoogleDriveDemo.controller;

import com.example.GoogleDriveDemo.model.ResponseModal;
import com.example.GoogleDriveDemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @RequestMapping("/login/oauth2")
    public String login(){
        System.out.println("Hello");
        return "index";
    }


//    @Autowired
//    LoginService loginService;
//
//    @PostMapping
//    public String login(@RequestParam String username, @RequestParam String password){
//        loginService.login(username,password);
//        return  "redirect:/home";
//
//    }
}
