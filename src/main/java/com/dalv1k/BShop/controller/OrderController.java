package com.dalv1k.BShop.controller;

import com.dalv1k.BShop.domain.Goods;
import com.dalv1k.BShop.domain.Order;
import com.dalv1k.BShop.repos.GoodsRepo;
import com.dalv1k.BShop.repos.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {


    @Autowired
    GoodsRepo goodsRepo;
    @Autowired
    OrdersRepo ordersRepo;

    @GetMapping("/order")
    public String order(Map<String, Object> pattern, @RequestParam int id){
        Goods goods = goodsRepo.findAllById(id);
        pattern.put("pp",goods);
        return "order";
    }


    @PostMapping("/order")
    public String order(@RequestParam String address, String phone, int id){


        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
             username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        Goods goods = goodsRepo.findAllById(id);

        Order order = new Order(username, goods.getBrand(), goods.getModel(), goods.getPrice(), address, phone);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        order.setDate(simpleDateFormat.format(date));
        ordersRepo.save(order);
        int newAmount = goods.getAmount()-1;
        goodsRepo.deleteById(goods.getId());
        Goods newgoods = new Goods(goods.getType(),goods.getBrand(),goods.getModel(),goods.getPrice(),goods.getDescription(),goods.getImgURL(),newAmount);
        goodsRepo.save(newgoods);
        return "category";
    }

}
