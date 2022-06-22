package com.woong.tacocloud.domain.repository;

import com.woong.tacocloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>
{
//    Order save(Order order);
}
