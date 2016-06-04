package com.eagle.dangdang.product.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eagle.dangdang.product.dao.ProductDAO;
import com.eagle.dangdang.product.entity.Product;
import com.eagle.dangdang.product.service.ProductService;
import com.eagle.dangdang.service.BaseService;

@Service
@Transactional
public class ProductServiceImpl extends BaseService implements ProductService{

	@Resource(name="productDao")
	private ProductDAO productDao;
	
	@Override
	public Product findProductById(long id) {
		return productDao.find(id);
	}

	public ProductDAO getProductDao() {
		return productDao;
	}

	public void setProductDao(ProductDAO productDao) {
		this.productDao = productDao;
	}

	
	
	
}