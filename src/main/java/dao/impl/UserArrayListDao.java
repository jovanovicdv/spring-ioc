package dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dao.UserDao;
import domain.User;

@Component(value = "userArrayListDao")
public class UserArrayListDao  implements UserDao{
	private List<User> users;
	
	public UserArrayListDao() {
		users = new ArrayList<User>();
	}
	public void save(User user) {
		users.add (user);
	}
	public void print() {
		for (User user : users) {
			System.out.println(user);
		}
	}

}
