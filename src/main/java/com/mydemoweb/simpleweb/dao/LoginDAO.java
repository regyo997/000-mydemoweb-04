package com.mydemoweb.simpleweb.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mydemoweb.simpleweb.entity.User;

@Repository
public class LoginDAO {
	@Autowired
	private EntityManager entityManager;
	
	public User findByEmail(String theEmail) {
		Session currentSession=entityManager.unwrap(Session.class);
		Query<?> theQuery =
				currentSession.createQuery("from User where email=:email");
		theQuery.setParameter("email", theEmail);
		if(theQuery.getResultList().size()>0)
			return (User) theQuery.getResultList().get(0);
		else
			return null;
	}
}
