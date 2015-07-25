package com.eagle.dangdang.product.service.impl;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;

import com.eagle.dangdang.product.dao.CategoryDAO;
import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Category;
import com.eagle.dangdang.product.entity.Pagination;
import com.eagle.dangdang.product.service.CategoryService;
import com.eagle.dangdang.service.BaseService;

/**
 * 
 * @author dpc 目录服务接口的具体实现
 *
 */
@SuppressWarnings("unchecked")
@Service("categoryService")
@Transactional
public class CategoryServiceImpl extends BaseService implements CategoryService {

	@Resource(name = "categoryDao")
	private CategoryDAO categoryDao;

	private static final Logger logger = LogManager
			.getLogger(CategoryServiceImpl.class);

	@Override
	public Category findCategoryById(long id) {
		return categoryDao.find(id);
	}

	@Override
	public List<Category> getCategoriesByLevel(int level) {
		return categoryDao.getCategoriesByLevel(level);
	}

	@Override
	public Set<Category> getSubCategories(long categoryId) {
		Category category=categoryDao.find(categoryId);
//		logger.info(categoryId+"的子目录为:"+categories.size()+"个");
		//Hibernate.initialize(category.getCategories());
		category.getCategories().size();
		return category.getCategories();
	}

	public CategoryDAO getCategoryDao() {
		return categoryDao;
	}

	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public Set<Book> getBooks(long categoryId) {
		Set<Book> books =categoryDao.find(categoryId).getBooks();
		logger.info(categoryId+"的书籍数目为:"+books.size()+"个");
		return books;
	}

	@Override
	public void initializeSub(Category category) {
		Hibernate.initialize(category.getCategories());
	}

	@Override
	public Category findCategoryByIdWithSub(long id) {
		 Category category =categoryDao.find(id);
		 category.getCategories().size();
		return category;
	}

	@Override
	public Pagination getBooksByCategoryId(long categoryId, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category getCategoryWithBooks(long categoryId) {
		return categoryDao.getBooks(categoryId);
	}

}
