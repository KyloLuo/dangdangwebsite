package com.eagle.dangdang.product.service;

import java.util.List;
import java.util.Set;

import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Category;
import com.eagle.dangdang.product.entity.Pagination;

/*目录信息的服务类接口*/
public interface CategoryService {

	//根据id查找对应的目录
	public Category findCategoryById(long id);
	
	//根据等级查找对应目录集合
	public List<Category> getCategoriesByLevel(int level);
	
	//返回一个目录的所有子目录集
	public Set<Category> getSubCategories(long categoryId);
	
	//根据目录查询到所属的所有book信息
	public Set<Book> getBooks(long categoryId);
	
	//带查直接一层的子目录查处category
	public Category findCategoryByIdWithSub(long id);
	
	public void initializeSub(Category category);
	
	//根据目录查找到所属的产品并分页显示
	public Pagination getBooksByCategoryId(long categoryId,int currentPage,int pageSize);

	
	//根据id查询返回一个目录对象，并携带其部分所属的图书信息
	public Category getCategoryWithBooks(long categoryId);
	
}
