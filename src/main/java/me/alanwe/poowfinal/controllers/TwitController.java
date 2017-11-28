package me.alanwe.poowfinal.controllers;

import me.alanwe.poowfinal.auth.AuthInterceptor;
import me.alanwe.poowfinal.models.Like;
import me.alanwe.poowfinal.models.Twit;
import me.alanwe.poowfinal.models.User;
import me.alanwe.poowfinal.services.LikeService;
import me.alanwe.poowfinal.services.TwitService;
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
@RequestMapping("twit")
public class TwitController {

    @Autowired
    private TwitService twitService;
    @Autowired
    private LikeService likeService;

    @InitBinder
    public void initBinder(final WebDataBinder dataBinder) {
        final StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, trimmer);
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public String show(final HttpSession session, final Model model) {
        List<Twit> twits = twitService.getTwits(10);
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        model.addAttribute("user", user);
        if (twits != null)
            model.addAttribute("twits", twits);
        return "twits";
    }

    @GetMapping(value="/create")
    public String getCreate(final Model model) {
        model.addAttribute("twit", new Twit());
        return "twit-create";
    }

    @PostMapping(value="/create")
    public String postCreate(@Valid @ModelAttribute("twit") final Twit twit,
                             final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "twit-create";
        }
        twitService.create(twit);
        return "redirect:/twit";
    }

    @GetMapping(value="/{id}/delete")
    public String delete(@PathVariable("id") final String id) {
        twitService.delete(Integer.valueOf(id));
        return "redirect:/twit";
    }

    @GetMapping(value="/{id}/update")
    public String update(final Model model,
                         @PathVariable("id") final String id) {
        System.out.println("ID: " + id);
        final Twit twit = twitService.get(Integer.valueOf(id));
        model.addAttribute("twit", twit);
        return "twit-update";
    }

    @PostMapping(value="/update")
    public String update(final HttpSession session,
                         @ModelAttribute("twit") final Twit twit) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        twit.setUser(user);
        twitService.update(twit);
        return "redirect:/twit";
    }

    @GetMapping(value="/{id}/like")
    public String like(final HttpSession session,
                       final Model model,
                       @PathVariable("id") final String id) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        final Twit twit = twitService.get(Integer.valueOf(id));
        final Like like = new Like();
        like.setUser(user);
        like.setTwit(twit);
        like.setPk(new Like.PK(user.getId(), twit.getId()));
        likeService.create(like);
        return "redirect:/twit";
    }

    @GetMapping(value="/{id}/unlike")
    public String unlike(final HttpSession session,
                         @PathVariable("id") final String id) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        final Twit t = twitService.get(Integer.valueOf(id));
        likeService.delete(new Like.PK(user.getId(), t.getId()));
        return "redirect:/twit";
    }

    @GetMapping(value="/trending")
    public String trending(final HttpSession session,
                           final Model model) {
        model.addAttribute("twits", twitService.getTrending(20));
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        model.addAttribute("user", user);
        return "trending";
    }

    @GetMapping(value="/mine")
    public String getMine(final HttpSession session,
                          final Model model) {
        final User user = (User) session.getAttribute(AuthInterceptor.USER_TAG);
        model.addAttribute("twits", twitService.getTwits(20, user));
        model.addAttribute("user", user);
        return "twit-mine";
    }


}
