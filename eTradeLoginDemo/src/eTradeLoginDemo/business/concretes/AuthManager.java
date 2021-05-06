package eTradeLoginDemo.business.concretes;

import java.util.regex.Pattern;

import eTradeLoginDemo.business.abstracts.AuthService;
import eTradeLoginDemo.business.abstracts.EmailService;
import eTradeLoginDemo.business.abstracts.UserService;
import eTradeLoginDemo.core.business.BusinessRules;
import eTradeLoginDemo.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;
	private EmailService emailService;

	public AuthManager(UserService userService, EmailService emailService) {
		this.emailService = emailService;
		this.userService = userService;
	}

	@Override
	public void login(String email, String password) {

		var user = userService.getByMail(email);
		if (user == null) {
			System.out.println("Böyle bir kullanıcı yok!");
			return;
		}
		System.out.println("Giris basarılı hosgeldiniz.." + user.getFirstName());
	}

	@Override
	public void register(User user) {

		if (!userExist(user.getGmail())) {
			System.out.println("Bu gmail zaten kullanılıyor!");
			return;
		}
		boolean result = BusinessRules.RunRules(checkPassword(user.getPassword()),
				checkName(user.getFirstName(), user.getLastName()), checkEmailPattern(user.getGmail()));

		if (result == true) {
			System.out.println("Kayýt baþarýlý");
			System.out.println("Doðrulama e postasý gönderildi");
			emailService.send(user.getGmail(), "Lütfen týklayýn");
			userService.add(user);
		} else {
			System.out.println("Kayýt baþarýsýz");
		}

	}

	private boolean userExist(String gmail) {

		return this.userService.getByMail(gmail) == null;
	}

	private boolean checkPassword(String password) {
		if (password.length() < 6) {
			System.out.println("Password 6 karakter olmalýdýr");
			return false;
		} else {
			return true;
		}

	}

	private boolean checkName(String firstName, String lastName) {
		if (firstName.length() < 2 || lastName.length() < 2) {
			System.out.println("Ad ve soyad en az 2 karakter içermelidir");
			return false;
		} else {
			return true;
		}
	}

	private boolean checkEmailPattern(String email) {
		Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
				Pattern.CASE_INSENSITIVE);
		return VALID_EMAIL_ADDRESS_REGEX.matcher(email).find();
	}

}