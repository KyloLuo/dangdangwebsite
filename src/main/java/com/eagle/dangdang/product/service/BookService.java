package com.eagle.dangdang.product.service;

import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Product;

/**
 * @author dpc
 * 书籍类商品的服务接口
 *
 */

public interface BookService {

	
	//添加一个新的商品信息并返回主键
	public long addProduct(Product product);
	
	//添加详细的书本信息
	public Book addBook(Book book);
	
	//根据书本的id获得其基本的商品信息
	public Product fingProductById(long id);
	
	//根据id获得书本的详细信息
	public Book findBookById(long id);
	
	
	
}
