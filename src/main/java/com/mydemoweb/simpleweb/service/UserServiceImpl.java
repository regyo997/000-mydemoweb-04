package com.mydemoweb.simpleweb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydemoweb.simpleweb.dao.UserRepository;
import com.mydemoweb.simpleweb.entity.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(int theId) {
		User theUser=null;
		Optional<User> result = userRepository.findById(theId);
		if(result.isPresent())
			theUser=result.get();
		else
			throw new RuntimeException("Did not foun user id - "+theId);
		return theUser;
		
	}

	@Override
	public void save(User theUser) {
		if(theUser.getAuthority()==null)
			theUser.setAuthority("nomal");
		userRepository.save(theUser);
	}

	@Override
	public void deleteById(int theId) {
		userRepository.deleteById(theId);
	}

}
