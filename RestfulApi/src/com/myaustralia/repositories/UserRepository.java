package com.myaustralia.repositories;

import java.util.List;

import com.myaustralia.beans.*;
import com.myaustralia.common.JsonHelper;
import com.myaustralia.dao.DAO;

public class UserRepository {

	public String getUsers() {
		User user = new User();
		List<User> users = new DAO().query(user.getClass(), "select UserName userName, Password password, Authority authority from dashboarduser");
		return JsonHelper.parseToJsonWithRoot(users);
	}
	
	public void create(User user) {
		new DAO().update("insert into dashboarduser(UserName, Password, Authority) values (?,?,?)", user.getUserName(), user.getPassword(), user.getAuthority());
	}

	public void update(User user) {
		new DAO().update("update dashboarduser set Password = ?, Authority = ? where UserName = ?", user.getPassword(), user.getAuthority(), user.getUserName());
	}

	public void delete(String userName) {
		new DAO().update("delete from dashboarduser where UserName = ?", userName);
	}
}