package com.woong.tacocloud.domain.repository;

import com.woong.tacocloud.domain.Order;

public interface OrderRepository
{
    Order save(Order order);
}
