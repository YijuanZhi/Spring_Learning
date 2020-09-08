package net.antra.deptemp.utility;

import javax.servlet.http.HttpServletRequest;

public class UserUtility {

	public static boolean validateUser(String name, String pwd, HttpServletRequest req) {
		return "admin".equalsIgnoreCase(name) && "1".equals(pwd);
	}

}
