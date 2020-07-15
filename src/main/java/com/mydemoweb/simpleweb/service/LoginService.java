package com.mydemoweb.simpleweb.service;

import com.mydemoweb.simpleweb.entity.User;

public interface LoginService {
	
	public User loginCheck(String email,String password);
	
}
