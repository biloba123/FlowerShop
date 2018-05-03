package util;

import javax.servlet.http.HttpSession;

import entity.User;

public class AccountUtil {
	public static boolean isLogined(HttpSession session) {
		return session.getAttribute("user") != null;
	}
	
	public static User getUser(HttpSession session) {
		return (User)session.getAttribute("user");
	}
	
	public static String backToLogin(HttpSession session, String msg) {
		session.setAttribute("errorMsg", msg);
		return "redirect:/Account/";
	}
}
