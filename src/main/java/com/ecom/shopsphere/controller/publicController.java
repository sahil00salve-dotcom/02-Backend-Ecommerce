package com.ecom.shopsphere.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class publicController {

    @RequestMapping("/Health-Check")
    public String healthcheck(){
        return "Application is Running !!";
    }
}
