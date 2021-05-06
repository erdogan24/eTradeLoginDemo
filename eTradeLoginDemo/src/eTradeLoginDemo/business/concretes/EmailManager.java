package eTradeLoginDemo.business.concretes;

import eTradeLoginDemo.business.abstracts.EmailService;

public class EmailManager implements EmailService{

	@Override
	public void send(String email, String message) {
		System.out.println("mesaj : "+email+"adresine gönderildi"+message);
		
	}

}
