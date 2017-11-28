package me.alanwe.poowfinal.controllers;

import me.alanwe.poowfinal.auth.AuthInterceptor;
import me.alanwe.poowfinal.auth.Crypto;
import me.alanwe.poowfinal.models.User;
import me.alanwe.poowfinal.services.TwitService;
import me.alanwe.poowfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TwitService twitService;

    @InitBinder
    public void initBinder(final WebDataBinder dataBinder) {
        final StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmer);
    }

    @GetMapping
    public String getUsers(final HttpSession session, final Model model) {
        final List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        model.addAttribute("me", session.getAttribute(AuthInterceptor.USER_TAG));
        return "users";
    }

    @GetMapping(value="/create")
    public String createUser(final Model model) {
        final User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping(value="/create")
    public String doCreateUser(@Valid @ModelAttribute("user")final User user,
                               final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        final Crypto.HashedPassword hashedPassword = Crypto.hashPassword(user.getPassword());
        user.setPassword(hashedPassword.getHashedPassword());
        user.setSalt(hashedPassword.getSalt());
        userService.createUser(user);
        return "redirect:/twit";
    }

    @GetMapping(value="/logout")
    public String logout(final HttpSession session) {
        if (session.getAttribute(AuthInterceptor.USER_TAG) != null)
            session.removeAttribute(AuthInterceptor.USER_TAG);
        return "redirect:/login";
    }

    @GetMapping(value="/{id}")
    public String getUser(final HttpSession session, final Model model,
                          @PathVariable("id") final String id) {
        final User me = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        final User user = userService.get(Integer.valueOf(id));

        model.addAttribute("me", me);
        model.addAttribute("user", user);
        model.addAttribute("twits", user.getTwits());
        return "user";
    }
//
//    @RequestMapping(name="/user", method=RequestMethod.POST, produces="application/json")
//    public void createUser(@ModelAttribute("User") User user) {
//
//    }

}
