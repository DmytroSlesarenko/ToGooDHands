package pl.coderslab.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.models.User;
import pl.coderslab.repositories.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginVerification(Model model, HttpServletRequest request) {
        model.addAttribute("error", checkUser(request));
        return "loginVerification";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/signup")
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signUp";
    }

    @PostMapping("/signup")
    public String signUpUser(Model model, HttpServletRequest request, User user) {
        if (checkSignUp(user, model, request).equals("email")) {
            return "signupVerification";
        } else if (checkSignUp(user, model, request).equals("password")){
            return "signupVerification";
        } else {
            user.setPassword(encoder.encode(user.getPassword()));
            user.setActive(true);
            user.setRole("USER");
            userRepository.save(user);
            return "redirect:/login";
        }
    }

    public boolean checkUser(HttpServletRequest request) {
        List<User> users = userRepository.findAll();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return !user.getPassword().equals(password);
            }
        }
        return false;
    }

    public String checkSignUp(User newUser, Model model, HttpServletRequest request) {
        List<User> users = userRepository.findAll();
        for (User user: users) {
            if (user.getEmail().equals(newUser.getEmail())) {
                model.addAttribute("error", "Email już istnieje, zaloguj się.");
                return "email";
            }
        }
        String passwordVerification = request.getParameter("password2");
        if (!newUser.getPassword().equals(passwordVerification)) {
            model.addAttribute("error", "Passwords not same!");
            return "password";
        }
        return "good";
    }
}
