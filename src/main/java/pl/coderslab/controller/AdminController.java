package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pl.coderslab.model.Company;
import pl.coderslab.model.User;
import pl.coderslab.service.CompanyService;
import pl.coderslab.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes({"loggedUserType", "error", "peselError"})
@RequestMapping(path = "/admin", produces = "text/html; charset=UTF-8")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @ModelAttribute("companies")
    public List<Company> getCompany() {
        return companyService.findAll();
    }

    @GetMapping("/adminHome")
    public String getPass() {
        return "admin/adminHome";
    }

    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("admins", userService.findAllAdmins());
        model.addAttribute("hrs", userService.findAllHrs());
        return "admin/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findOne(id));
        return "admin/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@Valid User user, BindingResult result, Model model, @RequestParam String newPassword) {
        if (result.hasErrors()) {
            return "admin/edit";
        }

        if (!newPassword.equals("")) {
            user.setPassword(userService.encryptPassword(newPassword));
        }
        userService.save(user);
        return "redirect:/admin/all";
    }

    @RequestMapping("/logout")
    public String logOut(Model model, HttpSession session, SessionStatus status) {
        model.addAttribute("loggedUserType", "loggedOut");
        model.addAttribute("error", "3");
        status.setComplete();
        session.invalidate();
        return "redirect:/";
    }


}
