package n16.hb_n16.rest;


import n16.hb_n16.entity.User;
import n16.hb_n16.impl.UserServiceImpl;
import n16.hb_n16.ultility.MyUltility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api_customer_admin")
public class UserRestController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/status_chart")
	public List<Integer> getUserChart() {
		return MyUltility.getUserGenderAmount(userServiceImpl.getAllUsers());
	}

	@GetMapping("/search")
	public List<String> search(@RequestParam String keyword) {
 
		List<User> users = userServiceImpl.searchUserALikeByKeyWord(keyword);

		List<String> res = new ArrayList<>();

		users.forEach(user -> {
			res.add(String.format("{\"cusID\":%d, \"phone\":\"%s\", \"firstName\":\"%s\" ,\"lastName\":\"%s\" }", user.getCustomerId(),
					user.getPhone(), user.getFirstName(), user.getLastName()));
		});

		return res;
	}
}