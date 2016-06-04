package com.eagle.dangdang.product.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.service.BookService;

@Controller
@RequestMapping(value="/book")
public class BookController {

	@Resource
	private BookService bookService;

	@RequestMapping(value="/hot/{num}",method=RequestMethod.GET)
	public String getHotBooks(@PathVariable("num")int num,Model model){
		List<Book> books =bookService.getHotBooks(num);
		model.addAttribute("hotBooks", books);
		return "main/rightTopBooks";//自定义试图名称
	}
	
	@RequestMapping(value="/last/{num}",method=RequestMethod.GET)
	public String getRecentBooks(@PathVariable("num")int num,Model model){
		System.out.println(num);
		List<Book> books =bookService.getRecentBooks(num);
		model.addAttribute("recentBooks", books);
		return "main/newbooks";//自定义试图名称
	}
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
	
	//具体购买链接
	@RequestMapping(value = "/bookcontent/{id}",method=RequestMethod.GET)
	public ModelAndView getBookContent(@PathVariable("id") long id) {
		Book book = bookService.findBookById(id);
		ModelAndView mav = new ModelAndView("main/bookcontent");
	    mav.addObject("book",book); 
		return mav;
	}
	
}
