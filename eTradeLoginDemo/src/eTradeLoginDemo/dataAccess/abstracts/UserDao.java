package eTradeLoginDemo.dataAccess.abstracts;

import java.util.List;

import eTradeLoginDemo.entities.concretes.User;

public interface UserDao {

	void add(User user);

	void update(User user);

	void delete(User user);

	User getById(int id);

	User getByMail(String email);

	List<User> getAll();

}
