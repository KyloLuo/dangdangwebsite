package com.eagle.dangdang.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Product;
import com.eagle.dangdang.product.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class BookServiceTest {

	@Resource(name = "bookService")
	private BookService bookService;

	//@Test
	public void testAddProduct() {
		Product product = new Product();
		product.setProductName("小王子（法国“圣埃克苏佩里基金会”唯一官方认可简体中文译本）");
		product.setAddTime(new Date(System.currentTimeMillis()));
		product.setFixedPrice(32.0);
		product.setDangPrice(22.10);
		product.setKeywords("超级畅销书");
		product.setHasDeleted(false);
		product.setProductPic("1.jpg");

		bookService.addProduct(product);
	}

	//@Test 
	public void testAddBook(){
		Book book =new Book();
		book.setProductName("小王子（法国“圣埃克苏佩里基金会”唯一官方认可简体中文译本）");
		book.setAuthor("（法）圣埃克苏佩里　著，李继宏　译");
		book.setPublishing("天津人民出版社");
		book.setPublishTime(new Date());
		book.setWordNumber("20万");
		book.setTotalPage(100);
		book.setWhichEdition("1");
		book.setPrintTime(100);
		book.setPrintNum(4000);
		book.setIsbn("9787201077642");
		book.setAuthorSummary("法国当代著名小说家");
		book.setCatalogue("导读小王子");
		
		bookService.addBook(book);
		
	}
	
	//@Test
	public void testGetProduct(){
		System.out.println(bookService.fingProductById(1));
	}
	
	@Test
	public void testGetBook(){
		Book book =bookService.findBookById(2);
		System.out.println(book.getProductName());
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
