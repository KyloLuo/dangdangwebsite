package com.eagle.dangdang.product.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.dangdang.product.dao.BookDAO;
import com.eagle.dangdang.product.dao.ProductDAO;
import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Product;
import com.eagle.dangdang.product.service.BookService;
import com.eagle.dangdang.service.BaseService;

@Service("bookService")
@Transactional
public class BookServiceImpl extends BaseService implements BookService{

	@Resource(name="productDao")
	private ProductDAO productDao;
	
	@Resource(name="bookDao")
	private BookDAO bookDao;
	
	private static final Logger logger =LogManager.getLogger(BookServiceImpl.class);
	
	@Override
	public long addProduct(Product product) {
		logger.info("begin to validate product");
		validate(product);
		return productDao.save(product);
	}

	@Override
	public Book addBook(Book book) {
		logger.info("begin to validate book");
		validate(book);
		bookDao.save(book);
		return book;
	}

	@Override
	public Product fingProductById(long id) {
		return productDao.find(id);
	}

	@Override
	public Book findBookById(long id) {
		return bookDao.find(id);
	}

	public ProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	public BookDAO getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getRecentBooks(int num) {
		
		return bookDao.getRecentBooks(num);
	}

	@Override
	public List<Book> getHotBooks(int num) {
		// TODO Auto-generated method stub
		return bookDao.getHotBooks(num);
	}
	
	

}