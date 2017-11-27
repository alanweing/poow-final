package me.alanwe.poowfinal.controllers;

import me.alanwe.poowfinal.auth.Crypto;
import me.alanwe.poowfinal.models.User;
import me.alanwe.poowfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public String getUsers(final Model model) {
        final Set<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value="/create", method=RequestMethod.GET)
    public String createUser(final Model model) {
        final User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public String doCreateUser(@ModelAttribute("user")final User user) {
        final Crypto.HashedPassword hashedPassword = Crypto.hashPassword(user.getPassword());
        user.setPassword(hashedPassword.getHashedPassword());
        user.setSalt(hashedPassword.getSalt());
        System.out.println(user);
        userService.createUser(user);
        return "redirect:/login";
    }
//
//    @RequestMapping(name="/user", method=RequestMethod.POST, produces="application/json")
//    public void createUser(@ModelAttribute("User") User user) {
//
//    }

}
