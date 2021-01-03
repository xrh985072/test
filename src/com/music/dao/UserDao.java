package com.music.dao;

import java.util.List;
import com.music.pojo.User;

public interface UserDao {
	public int addUser(User user);
	public int loginUser(User user);
	public int deleteUser(int uid);
	public int updateUser(int uid, User user);
	public List<User> findUser();
}
