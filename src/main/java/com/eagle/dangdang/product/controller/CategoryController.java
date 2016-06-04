package com.eagle.dangdang.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Category;
import com.eagle.dangdang.product.entity.CategoryForJson;
import com.eagle.dangdang.product.entity.Pagination;
import com.eagle.dangdang.product.entity.SubCategory;
import com.eagle.dangdang.product.service.CategoryService;
import com.eagle.dangdang.user.entity.User;

/**
 * @author dpc 负责目录相关请求的controller
 *
 */
@Controller
@RequestMapping(value = "/category")
public class CategoryController {

	@Resource(name = "categoryService")
	private CategoryService categoryService;

	@RequestMapping(value = "/{level}", method = RequestMethod.GET)
	public @ResponseBody List<CategoryForJson> getCategories(
			@PathVariable("level") int level) {
		List<CategoryForJson> jsonForReturn = new ArrayList<CategoryForJson>();
		List<Category> list = categoryService.getCategoriesByLevel(level);
		for (Category category : list) {
			CategoryForJson json = formatCateGory(category);
			jsonForReturn.add(json);
		}
		return jsonForReturn;
	}

	@RequestMapping(value = "/sub/{parent_id}", method = RequestMethod.GET)
	public @ResponseBody List<CategoryForJson> getSubCategoriesById(
			@PathVariable("parent_id") int id) {
		List<CategoryForJson> jsonForReturn = new ArrayList<CategoryForJson>();
		Set<Category> categories = categoryService.findCategoryByIdWithSub(id)
				.getCategories();// 获得其子目录
		for (Category cat : categories) {
			cat.setCategories(categoryService.getSubCategories(cat.getId()));// 获得第二季目录的子目录
			// 添加返回的json信息
			CategoryForJson json = formatCateGory(cat);
			// System.out.println(cat.getCategories().size()+"ceshi"+cat.getId());
			jsonForReturn.add(json);
		}
		return jsonForReturn;
	}

	// 商品显示
	@RequestMapping(value = "/{categoryId}/{currentPage}/{pageSize}", method = RequestMethod.GET)
	public String getBookByCategory(
			@PathVariable("categoryId") long categoryId,
			@PathVariable("currentPage") int currentPage,
			@PathVariable("pageSize") int pageSize, Model model,HttpSession session) {
		Pagination pagination =categoryService.getBooksByCategoryId(categoryId, currentPage, pageSize);
		User user = (User) session.getAttribute("currentUser");
		model.addAttribute("books_pageInfo", pagination);
		if(user!=null){
			return "main/userbooklist";
		}
		
		return "main/booklist";
		
		// 返回显示一页产品信息的页面
	}

	// 将一级目录只带其直接子目录返回，解决Json的循环解析问题
	public CategoryForJson formatCateGory(Category category) {
		CategoryForJson json = new CategoryForJson();
		json.setId(category.getId());
		json.setName(category.getName());
		json.setEnName(category.getEnName());
		json.setLevel(category.getLevel());

		// 解析其直接子目录
		for (Category sub : category.getCategories()) {
			SubCategory subCategory = new SubCategory();
			subCategory.setId(sub.getId());
			subCategory.setLevel(sub.getLevel());
			subCategory.setEnName(sub.getEnName());
			subCategory.setName(sub.getName());

			json.getCategories().add(subCategory);
		}
		return json;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	//主界面的一些跳转
		//头部
		@RequestMapping(value = "/headpage",method=RequestMethod.GET)
		public String getHeadPage() {
			return "common/head";
		}
		
		//侧边栏
		@RequestMapping(value = "/sidemenu",method=RequestMethod.GET)
		public String getSideMenuPage() {
			return "common/sidemenu";
		}
		
		//中间部分
		@RequestMapping(value = "/middle",method=RequestMethod.GET)
		public String getMiddlePage() {
			return "common/middle";
		}
		
		//底部部分
			@RequestMapping(value = "/foot",method=RequestMethod.GET)
			public String getFootPage() {
				return "common/foot";
			}
		
			//小说链接(判断)
			@RequestMapping(value = "/judgebooklist",method=RequestMethod.GET)
			public String judgeBookList(HttpSession session) {
				User user = (User) session.getAttribute("currentUser");
				if(user!=null){
					return "main/userbooklist";
				}
				
				return "main/booklist";
			}
			
			//小说链接(未登录)
			@RequestMapping(value = "/booklist",method=RequestMethod.GET)
			public ModelAndView getBookList() {
				ModelAndView mav = new ModelAndView("main/booklist");
			
				
				return mav;
			}
			
			//小说链接(已登录)
			@RequestMapping(value = "/userbooklist",method=RequestMethod.GET)
			public ModelAndView getUBookList() {
				ModelAndView mav = new ModelAndView("main/userbooklist");
			
				
				return mav;
			}
			
			
			
	
}
