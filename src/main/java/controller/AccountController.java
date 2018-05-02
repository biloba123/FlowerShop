package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import entity.User;
import service.UserService;

@Controller
@RequestMapping("/Account")
public class AccountController {
	@Autowired
	private UserService mUserService;

	@RequestMapping("/")
	public String index(HttpSession session) {
		if (isLogined(session)) {
			return "redirect:/Account/account-Info";
		}
		return "account/login";
	}

	@RequestMapping("/login")
	public String login(User user, HttpSession session) {
		User u = mUserService.login(user);
		if (u != null) {
			session.setAttribute("user", u);
			return "redirect:/Account/account-Info";
		} else {
			session.setAttribute("errorMsg", "用户名或密码错误");
			return "redirect:/Account/";
		}
	}

	@RequestMapping("/account-Info")
	public String accountInfo(HttpSession session) {
		if (!isLogined(session)) {
			return "redirect:/Account/";
		}
		return "account/account-Info";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/Account/";
	}

	@RequestMapping("/update-info")
	public String updateInfo(User user, HttpSession session) {
		User u = (User) session.getAttribute("user");
		user.setId(u.getId());
		mUserService.updateInfo(user);
		session.setAttribute("user", user);
		return "redirect:/Account/account-Info";
	}

	@RequestMapping("/register")
	public String register(HttpSession session) {
		return "account/register";
	}

	@RequestMapping("create-user")
	public String createUser(User user, HttpSession session) {
		mUserService.register(user);
		session.setAttribute("errorMsg", "注册成功，请登录");
		return "redirect:/Account/";
	}

	private boolean isLogined(HttpSession session) {
		return session.getAttribute("user") != null;
	}
}
