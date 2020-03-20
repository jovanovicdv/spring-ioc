package service.impl;

import java.util.Objects;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyConfig;
import dao.UserDao;
import domain.User;
import service.UserService;

@Component(value = "userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	@Qualifier(value = "userLinkedListDao")
	private  UserDao userDaoLinked;
	
	@Autowired
	@Qualifier(value = "userArrayListDao")
	private  UserDao userDaoArray;
	
	
	
	


	public void save(User user, String type) {
		if (Objects.equals(type, "array")) {
			System.out.println(userDaoArray.getClass().getCanonicalName());
			userDaoArray.save(user);
		}
		
		if (Objects.equals(type, "linked")) {
			System.out.println(userDaoLinked.getClass().getCanonicalName());
			userDaoLinked.save(user);
		}
	}

	public void print() {
		userDaoArray.print();
	}
	/*
	@Autowired
	@Qualifier(value = "linkedListDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	*/
	
}
