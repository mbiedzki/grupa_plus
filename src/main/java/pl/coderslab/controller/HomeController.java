package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;
import pl.coderslab.util.BCrypt;


@Controller
@RequestMapping(path = "/", produces = "text/html; charset=UTF-8")
@SessionAttributes("loggedUserType")
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getPass() {
        return "/home";
    }

    @PostMapping("/")
    public String checkPass(@RequestParam String pesel, @RequestParam String password, Model model) {

        User userToBeChecked = userService.findUserByPesel(pesel);

        if (BCrypt.checkpw(password, userToBeChecked.getPassword()) && userToBeChecked.isAdmin()) {
            model.addAttribute("loggedUserType", "admin");
            return "admin/adminHome";

        }
        return "redirect:/";
    }
}


