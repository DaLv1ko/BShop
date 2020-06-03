package com.dalv1k.BShop.controller;

import com.dalv1k.BShop.domain.Goods;
import com.dalv1k.BShop.repos.GoodsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class PhonesController {

    @Autowired
    GoodsRepo goodsRepo;

    @GetMapping("/category/phones")
    public String tv(Map<String, Object> patetrn){

        List<Goods> goodsList = goodsRepo.findAllByType("phone");
        for (Goods goodsLists:goodsList
             ) {
            if( goodsLists.getAmount() == 0){
                goodsLists.setPrice("Немає в наявності");
            }
        }
        patetrn.put("phones", goodsList);
        return "phones";
    }
}
