package com.dalv1k.BShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DevPageController {

    @GetMapping("/dev")
    public String dev(){
        return "dev";
    }
}
