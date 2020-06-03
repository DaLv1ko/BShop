package com.dalv1k.BShop.controller;

import com.dalv1k.BShop.domain.Order;
import com.dalv1k.BShop.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    OrdersRepo ordersRepo;

    @GetMapping("/user")
    public String user(Map<String, Object> pattern){
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        List<Order> order = ordersRepo.findByUsername(username);
        pattern.put("order", order);
        return "user";
    }
}
