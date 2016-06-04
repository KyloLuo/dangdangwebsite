package com.eagle.dangdang.user.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.user.dao.UserDAO;
import com.eagle.dangdang.user.entity.ReceiveAddress;
import com.eagle.dangdang.user.entity.User;

/**
 * 
 * @author dpc 用户DAO接口的具体实现类
 *
 */
@Repository("userDAO")
public class UserDAOImpl extends BaseDaoImpl<User, Long> implements UserDAO {

	@Override
	public User findUserByEmail(String email) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User authenticate(String email, String password) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		return (User) criteria.uniqueResult();
	}

	@Override
	public User addUser(User user) {
		long id = save(user);
		return find(id);
	}

	@Override
	public List<ReceiveAddress> getAddresses(long userId) {
		List<ReceiveAddress> addresses = new ArrayList<ReceiveAddress>(0);
		Session session = getSession();
		Query query = session
				.createQuery("select a from ReceiveAddress as a left join a.user as u where u.id=:id");
		query.setParameter("id", userId);
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			ReceiveAddress address = (ReceiveAddress) list.get(i);
//			System.out.println(address);
			addresses.add(address);
		}
		return addresses;
	}
}