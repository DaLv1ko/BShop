package com.dalv1k.BShop.repos;

import com.dalv1k.BShop.domain.Goods;
import com.dalv1k.BShop.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepo extends CrudRepository<Order, Long> {

    List<Order> findByUsername(String username);
}
