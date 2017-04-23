package main.java.spark.dao.dao;

import java.util.List;

import main.java.spark.dao.model.user.User;

public interface IUserDao {
	void saveOrUpateUser(User user);
	void deleteUser(User user);
	List<User> listUsers();
	User findByUsername(String username);
}
