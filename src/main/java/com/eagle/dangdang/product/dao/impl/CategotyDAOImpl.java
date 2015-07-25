package com.eagle.dangdang.product.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.eagle.dangdang.dao.BaseDaoImpl;
import com.eagle.dangdang.product.dao.CategoryDAO;
import com.eagle.dangdang.product.entity.Book;
import com.eagle.dangdang.product.entity.Category;

@SuppressWarnings("unchecked")
@Repository("categoryDao")
public class CategotyDAOImpl extends BaseDaoImpl<Category, Long> implements
		CategoryDAO {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public List<Category> getCategoriesByLevel(int level) {
		Criteria criteria = createCriteria();
		criteria.add(Restrictions.eqOrIsNull("level", level));
		return criteria.list();
	}

	@Override
	public Set<Category> getSubCategories(Category category) {
		return null;
	}

	@Override
	public Category getBooks(long id) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Category as c left join c.books as b  where c.id=:id");
		query.setParameter("id", id);	
		List list =query.list();
		for(int i=0;i<list.size();i++){
			 Object[] obj=(Object[])list.get(i);
			 Category category =(Category)obj[0];
			 Book book =(Book)obj[1];
			 System.out.println(category.toString());
			 System.out.println(book.toString());
		}
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
