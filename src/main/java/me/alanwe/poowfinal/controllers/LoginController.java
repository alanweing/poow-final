package me.alanwe.poowfinal.controllers;

import me.alanwe.poowfinal.models.User;
import me.alanwe.poowfinal.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(final WebDataBinder dataBinder) {
        final StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmer);
    }

    @GetMapping
    public String login(final Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping
    public String authenticate(final HttpServletRequest request, final Model model,
                               @Valid @ModelAttribute("user") final User userM,
                               final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        final User user = userService.authUser(request, userM.getLogin(), userM.getPassword());
        if (user == null) {
            model.addAttribute("error", "Wrong credentials");
            return "login";
        }
        return "twits";
    }

}
