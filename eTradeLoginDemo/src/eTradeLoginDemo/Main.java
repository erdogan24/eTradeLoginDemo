package eTradeLoginDemo;

import eTradeLoginDemo.business.abstracts.AuthService;
import eTradeLoginDemo.business.abstracts.EmailService;
import eTradeLoginDemo.business.abstracts.UserService;
import eTradeLoginDemo.business.concretes.AuthManager;
import eTradeLoginDemo.business.concretes.EmailManager;
import eTradeLoginDemo.business.concretes.UserManager;
import eTradeLoginDemo.core.adapters.GoogleAuthManagerAdapter;
import eTradeLoginDemo.dataAccess.concretes.HibernateUserDao;
import eTradeLoginDemo.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(2, "Erdogan", "Akpolat", "erdo98@gmail.com", "435455");
		User user2 = new User(3, "Gamze", "Akpolat", "gamze@gmail.com", "6535353");
		UserService userService = new UserManager(new HibernateUserDao());
		EmailService emailService = new EmailManager();
		AuthService authService = new AuthManager(userService, emailService);
		authService.register(user1);
		authService.login(user1.getGmail(), user1.getPassword());
		AuthService googleAuthService = new GoogleAuthManagerAdapter();
		googleAuthService.login(user1.getGmail(), user1.getPassword());
	}

}
