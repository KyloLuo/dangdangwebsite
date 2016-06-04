package com.eagle.dangdang.user.dao.impl;

import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.user.dao.ReceiveAddressDAO;
import com.eagle.dangdang.user.entity.ReceiveAddress;

@Repository("receiveAddressDao")
public class ReceiveDaoImpl extends BaseDaoImpl<ReceiveAddress, Long> implements ReceiveAddressDAO{

}