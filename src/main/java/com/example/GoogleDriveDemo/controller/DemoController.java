package com.example.GoogleDriveDemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hello")
//@PreAuthorize("hasAuthority('ROLE_APP_ADMIN')")
public class DemoController {
    @GetMapping
    public String get(){
        return "hello";
    }
}