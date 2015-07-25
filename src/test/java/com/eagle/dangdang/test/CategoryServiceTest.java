package com.eagle.dangdang.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Category;
import com.eagle.dangdang.product.service.CategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class CategoryServiceTest {

	@Resource(name="categoryService")
	private CategoryService categoryService;
	
	//@Test
	public void testGetCategory(){
		System.out.println(categoryService.findCategoryById(1));
	}
	
	//@Test
	public void testGetByLevel(){
		List<Category> list =categoryService.getCategoriesByLevel(1);
		Iterator<Category> it =list.iterator();
		System.out.println(list.size());
		while(it.hasNext()){
			Category category =it.next();
			System.out.println(category.getId()+":"+category.getName()+":"+categoryService.getSubCategories(category.getId()).size());
		}
	}
	
	//@Test
	public void testGetSub(){
		Set<Category> childs =categoryService.getSubCategories(2);
		Iterator<Category> it =childs.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	@Test
	public void testGetBooks(){
		Category category =categoryService.getCategoryWithBooks(1);
//		if(category.getBooks().size()>0)
//			System.out.println("query keyi");
	}

	
	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
}
