package com.eagle.dangdang.product.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.product.dao.BookDAO;
import com.eagle.dangdang.product.entity.Book;

@Repository("bookDao")
public class BookDAOImpl extends BaseDaoImpl<Book, Long> implements BookDAO{

	@Override
	public List<Book> getHotBooks(int size) {
		Criteria criteria =createCriteria();
		criteria.addOrder(Order.desc("printNum"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(size);
		return criteria.list();
	}

	@Override
	public List<Book> getRecentBooks(int size) {
		Criteria criteria =createCriteria();
		criteria.addOrder(Order.desc("addTime"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(size);
		return criteria.list();
	}


}