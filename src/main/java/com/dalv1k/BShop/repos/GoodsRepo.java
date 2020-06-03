package com.dalv1k.BShop.repos;

import com.dalv1k.BShop.domain.Goods;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GoodsRepo extends CrudRepository<Goods, Long> {

    List<Goods> findAll ();
    List<Goods> findAllByType (String type);
    Goods findAllById (Integer id);

    @Transactional
    int deleteById (int id);

}
