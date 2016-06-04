package com.eagle.dangdang.user.dao;

import java.util.List;

import com.eagle.dangdang.dao.BaseDao;
import com.eagle.dangdang.user.entity.ReceiveAddress;
import com.eagle.dangdang.user.entity.User;

/**
 * 
 * @author dpc
 *	用户DAO接口
 */
public interface UserDAO extends BaseDao<User, Long>{
	/**
	 * @param email
	 * @return user
	 */
	public User findUserByEmail(String email);
	
	/**
	 * @param email
	 * @param password
	 * @return user
	 */
	public User authenticate(String email,String password);
	
	
	/**
	 * @param user
	 * @return user
	 */
	public User addUser(User user);
	
	public List<ReceiveAddress> getAddresses(long userId);
	

}