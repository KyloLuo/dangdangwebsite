package com.eagle.dangdang.product.dao;

import java.util.List;
import java.util.Set;

import com.eagle.dangdang.dao.BaseDao;
import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Category;

/**
 * @author dpc
 *
 */
public interface CategoryDAO extends BaseDao<Category, Long>{

	/**
	 * @param level
	 * @return list<Category>
	 */
	public List<Category> getCategoriesByLevel(int level);
	
	/**
	 * @param category
	 * @return Set<Category>
	 */
	public Set<Category> getSubCategories(Category category);
	
	public List<Book> getBooks(long id,int pageIndex,int pageSize);
	
	
	/**
	 * @return int 
	 */
	public int getAttachBooksCount(long categoryId);
}
