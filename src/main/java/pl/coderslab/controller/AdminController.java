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

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("loggedUserType")
@RequestMapping(path="/admin", produces = "text/html; charset=UTF-8")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @GetMapping("/adminHome")
    public String getPass() {
        return "/admin/adminHome";
    }

    @ModelAttribute("companies")
    public List<Company> getCompany() {
        return companyService.findAll();
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
    public String edit(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "admin/edit";
        }
        userService.save(user);
        return "redirect:/admin/all";
    }

    @RequestMapping("/logout")
    public String logOut(Model model) {
        model.addAttribute("loggedUserType", "loggedOut");
        return "redirect:/";
    }


}
