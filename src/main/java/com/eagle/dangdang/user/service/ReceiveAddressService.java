package com.eagle.dangdang.user.service;

import com.eagle.dangdang.user.entity.ReceiveAddress;

public interface ReceiveAddressService {

	//持久化一个收货地址
	public ReceiveAddress saveAddress(ReceiveAddress address);
}