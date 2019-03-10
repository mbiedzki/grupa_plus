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
@SessionAttributes({"loggedUserType", "error", "userId"})
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getPass() {
        return "home";
    }

    @PostMapping("/")
    public String checkPass(@RequestParam String pesel, @RequestParam String password, Model model) {
        model.addAttribute("error", "0");

        User userToBeChecked = userService.findUserByPesel(pesel);
        if(userToBeChecked==null) {
            model.addAttribute("error", "1");
            return "home";
        }

        if (BCrypt.checkpw(password, userToBeChecked.getPassword()) && userToBeChecked.isAdmin()) {

           //jeżeli hasło=pesel (z userService) to zmiana hasła
            model.addAttribute("loggedUserType", "admin");
            model.addAttribute("userId", userToBeChecked.getId());
            return "redirect:/admin/adminHome";

        }

        if (BCrypt.checkpw(password, userToBeChecked.getPassword())) {

            //jeżeli hasło=pesel (z userService) to zmiana hasła
            model.addAttribute("loggedUserType", "user");
            model.addAttribute("userId", userToBeChecked.getId());
            return "redirect:/employee/view";

        }

        model.addAttribute("error", "1");
        return "home";
    }
}


