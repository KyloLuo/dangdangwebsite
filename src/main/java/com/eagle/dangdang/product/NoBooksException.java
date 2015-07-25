package com.eagle.dangdang.product;

import com.eagle.dangdang.exception.BaseWebApplicationException;

public class NoBooksException extends BaseWebApplicationException{

	public NoBooksException() {
		super(404, "该目录还没有相关图书", "目录对应的图书为0");
		// TODO Auto-generated constructor stub
	}

}
