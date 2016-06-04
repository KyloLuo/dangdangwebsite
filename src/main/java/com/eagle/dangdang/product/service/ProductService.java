package com.eagle.dangdang.product.service;

import com.eagle.dangdang.product.entity.Product;

public interface ProductService {

	//根据id查找到相应的product
	public Product findProductById(long id);
}
