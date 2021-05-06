package eTradeLoginDemo.business.concretes;

import java.util.List;

import eTradeLoginDemo.business.abstracts.UserService;
import eTradeLoginDemo.dataAccess.abstracts.UserDao;
import eTradeLoginDemo.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		this.userDao.add(user);

	}

	@Override
	public List<User> getAll() {

		return this.userDao.getAll();
	}

	@Override
	public User getByMail(String gmail) {

		return this.userDao.getByMail(gmail);
	}

}
