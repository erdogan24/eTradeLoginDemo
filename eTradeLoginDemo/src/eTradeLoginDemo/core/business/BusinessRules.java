package eTradeLoginDemo.core.business;

public class BusinessRules {
	public static boolean RunRules(Boolean... logics) {
		for (Boolean logic : logics) {
			if (logic != true) {
				return logic;
			}
		}
		return true;
	}

}
