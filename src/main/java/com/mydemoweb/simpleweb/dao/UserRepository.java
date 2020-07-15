package com.mydemoweb.simpleweb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydemoweb.simpleweb.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	//什麼都不用打　只要填好<T, ID>
	
}
