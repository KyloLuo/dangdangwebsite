package com.eagle.dangdang.product.entity;

import java.util.ArrayList;
import java.util.List;

/*为了方便json数据返回的  Category类*/
public class CategoryForJson {

	private long id;

	private String name;

	private String enName;

	private int level;
	
	private List<SubCategory> categories=new ArrayList<SubCategory>(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<SubCategory> getCategories() {
		return categories;
	}

	public void setCategories(List<SubCategory> categories) {
		this.categories = categories;
	}

	public CategoryForJson() {
		super();
	}
	
	
	
}
