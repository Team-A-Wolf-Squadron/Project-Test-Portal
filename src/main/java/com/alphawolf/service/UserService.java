package com.alphawolf.service;

import java.util.List;

import com.alphawolf.model.StudentTest;
import com.alphawolf.model.User;

public interface UserService {
	
	User save(User user);
	
	List<User> findAllUsers();
	
	User findByUsername(String username);
	
	User update(User user, User newUserInfo, String newPassword);

	User update(User user);

	User update(User user, StudentTest studentTest);

}
