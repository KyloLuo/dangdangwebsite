package com.eagle.dangdang.product.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.product.dao.ProductDAO;
import com.eagle.dangdang.product.entity.Product;

@Repository("productDao")
public class ProductDAOImpl extends BaseDaoImpl<Product, Long> implements ProductDAO{

}
