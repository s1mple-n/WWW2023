package n16.hb_n16.controller;


import jakarta.servlet.http.HttpServletRequest;
import n16.hb_n16.entity.User;
import n16.hb_n16.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public String welcomePage(Model model, HttpServletRequest request) {
		System.out.println("Bat dau load trang chu");
		User user = UserSession.getCurrentUser(userService);
		model.addAttribute("request", request);
		System.out.println("da add model");
		if (user != null && user.getRole().equalsIgnoreCase("admin")) {
			UserSession.getLoggedUserInfo(userService, model);

			model.addAttribute("pageTitle", "G9 - Quản lí đơn hàng");
			System.out.println("ve admin");
			return "redirect:/admin/all";
		}

		UserSession.getLoggedUserInfo(userService, model);

		model.addAttribute("pageTitle", "G9 Bag Store");
		System.out.println("ve index");
		return "view_customer/index";
	}
	@GetMapping("/")
	public String welcomePage2(Model model, HttpServletRequest request) {
		System.out.println("Bat dau load trang chu /");
		User user = UserSession.getCurrentUser(userService);
		model.addAttribute("request", request);
		System.out.println("da add model");
		if (user != null && user.getRole().equalsIgnoreCase("admin")) {
			UserSession.getLoggedUserInfo(userService, model);

			model.addAttribute("pageTitle", "G9 - Quản lí đơn hàng");
			System.out.println("ve admin");
			return "redirect:/admin/all";
		}

		UserSession.getLoggedUserInfo(userService, model);

		model.addAttribute("pageTitle", "G9 Bag Store");
		System.out.println("ve index");
		return "view_customer/index";
	}

	@GetMapping("/login")
	public String loginPage() {
		System.out.println("bat dau load trang login");
		if(UserSession.getCurrentUser(userService) != null)
			return "redirect:/";

		return "view_customer/login";
	}


}