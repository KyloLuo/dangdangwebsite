package com.eagle.dangdang.product.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.product.dao.BookDAO;
import com.eagle.dangdang.product.entity.Book;

@Repository("bookDao")
public class BookDAOImpl extends BaseDaoImpl<Book, Long> implements BookDAO{

}
