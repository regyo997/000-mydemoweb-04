package com.mydemoweb.simpleweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydemoweb.simpleweb.dao.LoginDAO;
import com.mydemoweb.simpleweb.entity.User;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDAO loginDAO;
	
	
	@Override
	public User loginCheck(String email,String password) {
		User theUser=loginDAO.findByEmail(email);
		if(theUser!=null&&theUser.getPassword().equals(password))
			return theUser;
		else
			return null;
	}

}
