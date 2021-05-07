package eTradeLoginDemo.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTradeLoginDemo.dataAccess.abstracts.UserDao;
import eTradeLoginDemo.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	private List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Kullanýcý eklendi :" + user.getFirstName());
		users.add(user);
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý güncellendi :" + user.getFirstName());
	}

	@Override
	public void delete(User user) {
		System.out.println("Kullanýcý silindi :" + user.getFirstName());

	}

	@Override
	public User getById(int id) {

		return null;
	}

	@Override
	public User getByMail(String email) {
		for (User user : users) {
			if (user.getEmail() == email) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {

		return users;
	}

}
