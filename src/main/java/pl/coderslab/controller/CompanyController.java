package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Address;
import pl.coderslab.model.Company;
import pl.coderslab.model.User;
import pl.coderslab.service.AddressService;
import pl.coderslab.service.CompanyService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/company", produces = "text/html; charset=UTF-8")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("company", new Company());
        return "company/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Company company, BindingResult result) {
        if(result.hasErrors()) {
            return "company/add";
        }
        companyService.save(company);
        return "redirect:/company/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
            model.addAttribute("company", companyService.findOne(id));
        return "company/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String edit(@Valid Company company, BindingResult result) {
        if(result.hasErrors()) {
            return "company/edit";
        }
        companyService.save(company);
        return "redirect:/company/all";
    }



    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (companyService.noUsersInCompany(id)) {
            companyService.delete(id);
            return "redirect:/company/all";
        } else {
            model.addAttribute("deleteError", true);
            model.addAttribute("companies", companyService.findAll());
            return "company/all";
        }
    }


    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("companies", companyService.findAll());
        return "company/all";
    }



}
