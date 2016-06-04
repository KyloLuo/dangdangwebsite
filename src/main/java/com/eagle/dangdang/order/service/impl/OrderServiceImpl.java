package com.eagle.dangdang.order.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eagle.dangdang.order.dao.OrderDao;
import com.eagle.dangdang.order.entity.Order;
import com.eagle.dangdang.order.service.OrderService;
import com.eagle.dangdang.service.BaseService;

@Service
@Transactional
public class OrderServiceImpl extends BaseService implements OrderService{

	@Resource
	private OrderDao orderDao;
	
	@Override
	public Order createOrder(Order order) {
		long id =orderDao.save(order);
		return orderDao.find(id);
	}

	@Override
	public List<Order> getOrderByUserId(long userId) {
		return orderDao.getOrderByUserId(userId);
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	
}
