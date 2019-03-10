package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Company;
import pl.coderslab.model.User;
import pl.coderslab.service.CompanyService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/password", produces = "text/html; charset=UTF-8")
@SessionAttributes({"passwordChanged", "loggedUserType", "passwordError", "error"})
public class PasswordController {
    @Autowired
    private UserService userService;


    //password change
    //*****************************************************************************
    @GetMapping(path = "/change")
    public String password(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        User userToBeUpdated = userService.findOne(userId);
        model.addAttribute("user", userToBeUpdated);
        model.addAttribute("newPass1", "");
        model.addAttribute("newPass2", "");
        return "password/change";
    }

    @PostMapping(path = "/change")
    public String savePassword(@RequestParam String newPass1, @RequestParam String newPass2, HttpSession session, Model model) {
        if (!newPass1.equals(newPass2)) {
            model.addAttribute("passwordError", true);
            return "redirect:/password/change";
        }
        Long userId = (Long) session.getAttribute("userId");
        User userToBeUpdated = userService.findOne(userId);
        userToBeUpdated.setPassword(userService.encryptPassword(newPass1));
        userService.save(userToBeUpdated);
        model.addAttribute("passwordChanged", true);
        model.addAttribute("loggedUserType", "loggedOut");
        model.addAttribute("error", "3");
        return "redirect:/";
    }

}
