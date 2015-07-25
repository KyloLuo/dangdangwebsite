package com.eagle.dangdang.product.entity;

import java.util.List;

/*分页显示产品的分页组件*/
public class Pagination {
	private int currentPage;
	private int pageSize;
	private int totalCount;
	private int totalPages;
	
	private List<Book> products;

	public Pagination() {
		super();
	}


	public Pagination(int currentPage, int pageSize, int totalCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<Book> getProducts() {
		return products;
	}

	public void setProducts(List<Book> products) {
		this.products = products;
	}
	
	
}
