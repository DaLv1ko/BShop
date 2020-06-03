package com.dalv1k.BShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainCotroller {

@GetMapping("/")
    public String greeting(Map<String, Object> stringObjectMap){
    return "bshop";
}
}
