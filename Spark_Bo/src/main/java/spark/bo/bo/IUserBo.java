package main.java.spark.bo.bo;

import java.util.List;

import main.java.spark.dao.model.user.User;

public interface IUserBo {
	void saveOrUpateUser(User user);
	void deleteUser(User user);
	List<User> listUsers();
	User findByUsername(String username);
}
