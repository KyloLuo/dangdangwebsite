package com.eagle.dangdang.order.service;

import java.util.List;

import com.eagle.dangdang.order.entity.Order;

public interface OrderService {

	//持久化一条新的订单
	public Order createOrder(Order order);
	
	//根据用户id查找到其所属的订单信息
	public List<Order> getOrderByUserId(long userId);
}
