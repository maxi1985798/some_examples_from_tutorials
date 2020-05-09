package springmvc.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import springmvc.java.dao.UserDAO;
import springmvc.java.domain.User;
import springmvc.java.service.UserService;


public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	

	@Override
	public User findUserById(long id) {
		return userDAO.findOne(id);
	}

	@Override
	public User findUserWithBlogPostByUsername(String username) {
		return userDAO.findUserByUserName(username);
	}

}
