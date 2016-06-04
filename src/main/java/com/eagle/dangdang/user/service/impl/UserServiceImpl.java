package com.eagle.dangdang.user.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.eagle.dangdang.service.BaseService;
import com.eagle.dangdang.user.dao.UserDAO;
import com.eagle.dangdang.user.entity.ReceiveAddress;
import com.eagle.dangdang.user.entity.User;
import com.eagle.dangdang.user.service.UserService;

/**
 * @author dpc User服务类接口的具体实现
 */

@Service("userService")
@Transactional
public class UserServiceImpl extends BaseService implements UserService {

	@Resource
	private UserDAO userDAO;

	private static final Logger logger = LogManager
			.getLogger(UserServiceImpl.class);

	@Override
	public User findUserByEmail(String email) {
		return userDAO.findUserByEmail(email);
	}

	@Override
	public User authenticate(String email, String password) {
		User user =userDAO.authenticate(email, password);
		return user;
	}

	@Override
	public User addUser(User user) {
		logger.info("validate user ...");
		validate(user);
		long id =userDAO.save(user);
		return userDAO.find(id);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User updateUser(User user) {
		validate(user);
		userDAO.update(user);
		return user;
	}

	@Override
	public List<ReceiveAddress> getAddresses(long userId) {
		return userDAO.getAddresses(userId);
	}

}