package n16.hb_n16.controller;

import n16.hb_n16.entity.User;
import n16.hb_n16.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/all")
    public String showRegisterPage(Model model){
        model.addAttribute("pageTitle", "Đăng kí tài khoản");
        return "view_customer/register";
    }

    @PostMapping("/regis")
    public String register(@ModelAttribute User user) {

        if(userServiceImpl.getUserByUserName(user.getUsername()) != null)
            return "redirect:/register/all?error";

        user.setEmail("");
        user.setGender("Nam");
        user.setAddress("");
        user.setPhone("");
        user.setAvatar("");
        user.setRole("USER");

        userServiceImpl.addOrUpdateUser(user);

        return "redirect:/login";
    }
}