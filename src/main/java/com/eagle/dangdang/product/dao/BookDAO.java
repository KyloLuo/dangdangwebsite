package com.eagle.dangdang.product.dao;

import java.util.List;

import com.eagle.dangdang.dao.BaseDao;
import com.eagle.dangdang.product.entity.Book;

public interface BookDAO extends BaseDao<Book, Long>{

	public List<Book> getHotBooks(int size);
	
	public List<Book> getRecentBooks(int size);
}
