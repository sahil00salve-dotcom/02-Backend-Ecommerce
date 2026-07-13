package com.ecom.shopsphere.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/Health-Check")
    public String healthcheck(){
        return "Application is Running !!";
    }
}
