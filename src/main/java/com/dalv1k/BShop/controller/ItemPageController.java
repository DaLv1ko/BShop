package com.dalv1k.BShop.controller;

import com.dalv1k.BShop.domain.Goods;
import com.dalv1k.BShop.repos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ItemPageController {

    @Autowired
    GoodsRepo goodsRepo;


    @GetMapping("/itempage")
    public String itemPage(Map<String,Object> pattern,
                           @RequestParam int id){
        Goods goods = goodsRepo.findAllById(id);
        if( goods.getAmount() == 0){
            goods.setPrice("Немає в наявності");
            pattern.put("iii",goods);
            return "itempageN";
        }
        System.out.println(goods.getId().toString());
    pattern.put("iii", goods);
        return "itempage";
    }
}
