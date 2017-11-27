package me.alanwe.poowfinal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/twit")
public class TwitController {

    @GetMapping
    public String show(final Model model) {
        return "twits";
    }

}
