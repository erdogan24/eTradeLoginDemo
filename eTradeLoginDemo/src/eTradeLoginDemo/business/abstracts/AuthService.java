package eTradeLoginDemo.business.abstracts;

import eTradeLoginDemo.entities.concretes.User;

public interface AuthService {

	void login(String email, String password);

	void register(User user);
}
