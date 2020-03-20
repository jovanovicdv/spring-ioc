package service;

import domain.User;

public interface UserService {
	void save (User user, String type);

	void print();
}
