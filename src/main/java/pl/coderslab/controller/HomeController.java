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
@SessionAttributes({"loggedUserType", "error", "insuredId"})
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getPass() {
        return "/home";
    }

    @PostMapping("/")
    public String checkPass(@RequestParam String pesel, @RequestParam String password, Model model) {
        model.addAttribute("error", "0");

        User userToBeChecked = userService.findUserByPesel(pesel);
        if(userToBeChecked==null) {
            model.addAttribute("error", "1");
            return "redirect:/";
        }

        if (BCrypt.checkpw(password, userToBeChecked.getPassword()) && userToBeChecked.isAdmin()) {
            model.addAttribute("loggedUserType", "admin");
            return "admin/adminHome";

        }

        if (BCrypt.checkpw(password, userToBeChecked.getPassword())) {
            model.addAttribute("loggedUserType", "user");
            model.addAttribute("insuredId", userToBeChecked.getId());
            System.out.println("zapisanie w home cont userid = " + userToBeChecked.getId().toString());
            return "redirect:/employee/view";

        }

        model.addAttribute("error", "2");
        return "redirect:/";
    }
}


