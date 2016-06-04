package com.eagle.dangdang.user.service;

import java.util.List;

import com.eagle.dangdang.user.entity.ReceiveAddress;
import com.eagle.dangdang.user.entity.User;


/**
 * @author dpc
 * User 的服务类接口
 *
 */
public interface UserService {

	//根据email查询用户
	public User findUserByEmail(String email);
	
	//根据emial和password验证用户是否合法，存在即返回
	public User authenticate(String email,String password);
	
	//添加一个新的用户
	public User addUser(User user);
	
	//跟新一个User对象
	public User updateUser(User user);
	
	//根据用户id获得其所有的收货地址
	public List<ReceiveAddress> getAddresses(long userId);
}