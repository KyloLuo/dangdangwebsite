package com.eagle.dangdang.order.dao;

import java.util.List;

import com.eagle.dangdang.dao.BaseDao;
import com.eagle.dangdang.order.entity.Order;

public interface OrderDao extends BaseDao<Order, Long>{

	/**
	 * @return List<Order>
	   2015年7月25日
	 */
	public List<Order> getOrderByUserId(long userId);
}
