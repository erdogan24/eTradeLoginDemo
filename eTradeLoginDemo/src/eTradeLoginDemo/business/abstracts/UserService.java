package eTradeLoginDemo.business.abstracts;

import java.util.List;

import eTradeLoginDemo.entities.concretes.User;

public interface UserService {
	
	void add(User user);
	List<User> getAll();
	User getByMail(String gmail);

}
