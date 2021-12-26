package com.betaplan.himi.tvshows_exam.controllers;

import com.betaplan.himi.tvshows_exam.models.Show;
import com.betaplan.himi.tvshows_exam.models.User;
import com.betaplan.himi.tvshows_exam.services.RatingService;
import com.betaplan.himi.tvshows_exam.services.ShowService;
import com.betaplan.himi.tvshows_exam.services.UserService;
import com.betaplan.himi.tvshows_exam.validator.ShowValidator;
import com.betaplan.himi.tvshows_exam.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShowService showService;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private ShowValidator showValidator;
    @Autowired
    private RatingService ratingService;

    //User Controller for LogIn(LogOut) and Registration
    @GetMapping("/")
    public String index(@ModelAttribute("user") User user) {
        return "/user/registration";
    }

    //Register form controller
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "/user/registration";
        } else {
            User u = userService.registerUser(user);
            session.setAttribute("userId", u.getId());
        }
        return "redirect:/shows";
    }

    //LogIn form controller
    @PostMapping(value = "/login")
    public String loginUser(@RequestParam("email") String email,
                            @RequestParam("password") String password,
                            Model model,
                            RedirectAttributes redirectAttr,
                            HttpSession session) {
        boolean isAuthenticated = userService.authenticateUser(email, password);
        if (isAuthenticated) {
            User user = userService.findUserByEmail(email);
            session.setAttribute("userId", user.getId());
            return "redirect:/shows";
        } else {
            redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
            return "redirect:/";
        }
    }

    //LogOut Form Controller
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    //Finish User Controller

    //Show Controller
    @RequestMapping("/shows")
    public String home(HttpSession session, @ModelAttribute("user") User user, Model model) {
        Long userId = (Long) session.getAttribute("userId");
        User u = userService.findUserById(userId);
        model.addAttribute("user", u);
        model.addAttribute("shows", this.showService.findAllShows());
        return "/show/index";
    }

    //create an idea
    @GetMapping("/shows/new")
    public String createShow(@ModelAttribute("show") Show show, HttpSession session, Model model) {
        model.addAttribute("userID", (Long) session.getAttribute("userId"));
        return "/show/new";
    }

    @PostMapping("/shows/new")
    public String newShow(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session) {
        showValidator.validate(show, result);
        User user = this.userService.findUserById((Long) session.getAttribute("userId"));
        show.setCreator(user);
        if (result.hasErrors()) {
            return "/show/new";
        }
        this.showService.createAnEditShow(show);
        return "redirect:/shows";
    }

    //Show details for show
    @GetMapping("/shows/{id}")
    public String showPost(@PathVariable("id") Long id, Model model, HttpSession session) {
        model.addAttribute("show", this.showService.finShowById(id));
        model.addAttribute("loggedInUser", (Long) session.getAttribute("userId"));
        return "/show/details";
    }

    //Edit and delete only by user who create idea
    @GetMapping("/shows/{id}/edit")
    public String editShow(@PathVariable("id") Long id, Model model) {
        model.addAttribute("show", this.showService.finShowById(id));
        return "/show/edit";
    }

    @PutMapping("/shows/{id}/edit")
    public String updateShow(@Valid @ModelAttribute("show") Show show, BindingResult result,HttpSession session) {
        User user = this.userService.findUserById((Long)session.getAttribute("userId"));
        show.setCreator(user);
        if (result.hasErrors()) {
            return "/show/edit";
        } else {
            this.showService.createAnEditShow(show);
            return "redirect:/shows";
        }
    }
    @DeleteMapping("/shows/{id}/delete")
    public String deleteShow(@PathVariable("id") Long id){
        this.showService.deleteShow(id);
        return "redirect:/shows";
    }
    @PostMapping("/shows/{id}/rating")
    public String showRating(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session){
        if (result.hasErrors()) {
            return "redirect:/shows/{id}";
        }
        this.showService.createAnEditShow(show);
        return "redirect:/shows";
    }

}
