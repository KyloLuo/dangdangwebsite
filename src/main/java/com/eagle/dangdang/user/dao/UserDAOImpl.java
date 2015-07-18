package com.eagle.dangdang.user.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.user.entity.User;

/**
 * 
 * @author dpc
 * 用户DAO接口的具体实现类
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDaoImpl<User, Long> implements UserDAO{

	@Override
	public User findUserByEmail(String email) {
		Criteria criteria=createCriteria();
		criteria.add(Restrictions.eq("email", email));
		return (User)criteria.uniqueResult();
	}

	@Override
	public User authenticate(String email, String password) {
		Criteria criteria=createCriteria();
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		return (User)criteria.uniqueResult();
	}

	@Override
	public User addUser(User user) {
		long id =save(user);
		return find(id);
	}
}
