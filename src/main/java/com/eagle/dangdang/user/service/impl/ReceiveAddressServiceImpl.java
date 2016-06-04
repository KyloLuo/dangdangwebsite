package com.eagle.dangdang.user.service.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.eagle.dangdang.service.BaseService;
import com.eagle.dangdang.user.dao.ReceiveAddressDAO;
import com.eagle.dangdang.user.entity.ReceiveAddress;
import com.eagle.dangdang.user.service.ReceiveAddressService;

@Service
@Transactional
public class ReceiveAddressServiceImpl extends BaseService implements ReceiveAddressService{

	@Resource(name="receiveAddressDao")
	private ReceiveAddressDAO receiveAddressDao;
	
	@Override
	public ReceiveAddress saveAddress(ReceiveAddress address) {
		long id =receiveAddressDao.save(address);
		return receiveAddressDao.find(id);
	}

	public ReceiveAddressDAO getReceiveAddressDao() {
		return receiveAddressDao;
	}

	public void setReceiveAddressDao(ReceiveAddressDAO receiveAddressDao) {
		this.receiveAddressDao = receiveAddressDao;
	}

	
}