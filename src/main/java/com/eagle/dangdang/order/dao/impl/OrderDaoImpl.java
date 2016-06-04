package com.eagle.dangdang.order.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.order.dao.OrderDao;
import com.eagle.dangdang.order.entity.Order;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Order, Long> implements OrderDao {

	@Override
	public List<Order> getOrderByUserId(long userId) {
		List<Order> orders =new ArrayList<Order>(0);
		Session session = getSession();
		Query query = session
				.createQuery("select o from Order as o left join o.user as u where u.id=:id");
		query.setParameter("id", userId);
		List list =query.list();
		for(int i=0;i<list.size();i++){
			Order order =(Order)list.get(i);
			orders.add(order);
			System.out.println(order.toString());
		}
		return orders;
	}
	
	
	

}
