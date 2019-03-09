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
@RequestMapping(path = "/user", produces = "text/html; charset=UTF-8")
@SessionAttributes({"deleteError"})
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @ModelAttribute("companies")
    public List<Company> getCompany() {
        return companyService.findAll();
    }

    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/add";
        }
        user.setPassword(user.getPesel());
        userService.save(user);
        return "redirect:/user/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("user", userService.findOne(id));
        return "user/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user/edit";
        }
        userService.save(user);
        return "redirect:/user/all";
    }

    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (userService.noContractsWithInsuredId(id) && userService.noContractsWithBeneficiaryId(id)) {
            userService.delete(id);
            return "redirect:/user/all";
        } else {
            model.addAttribute("deleteError", true);
            model.addAttribute("users", userService.findAll());
            return "redirect:/user/all";
        }
    }


        //all
        //*****************************************************************************
        @RequestMapping("/all")
        public String all (Model model){
            model.addAttribute("users", userService.findAll());
            return "user/all";
        }

    }
