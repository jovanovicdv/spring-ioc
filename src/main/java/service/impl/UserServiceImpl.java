package service.impl;

import java.util.Objects;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import config.MyConfig;
import dao.UserDao;
import domain.User;
import service.UserService;

@Component(value = "userService")
public class UserServiceImpl implements UserService {
	
	
	private  UserDao userDao;
	
	
	
	


	public void save(User user, String type) {
		BeanFactory container = new AnnotationConfigApplicationContext(MyConfig.class);
		if (Objects.equals(type, "array")) {
			userDao = container.getBean("userArrayListDao", UserDao.class);
			System.out.println(userDao.getClass().getCanonicalName());
			userDao.save(user);
		}
		
		if (Objects.equals(type, "linked")) {
			userDao = container.getBean("userLinkedListDao", UserDao.class);
			System.out.println(userDao.getClass().getCanonicalName());
			userDao.save(user);
		}
		((AnnotationConfigApplicationContext)container).close();
	}

	public void print() {
		userDao.print();
	}
	/*
	@Autowired
	@Qualifier(value = "linkedListDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	*/
	
}
