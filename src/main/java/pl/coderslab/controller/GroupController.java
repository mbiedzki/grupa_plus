package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Company;
import pl.coderslab.model.Group;
import pl.coderslab.model.Product;
import pl.coderslab.service.CompanyService;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.ProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path="/group", produces = "text/html; charset=UTF-8")
public class GroupController {
    @Autowired
    private GroupService groupService;
    @Autowired
    private ProductService productService;
    @Autowired
    private CompanyService companyService;

    @ModelAttribute("products")
    public List<Product> getProducts() {
        return productService.findAll();
    }

    @ModelAttribute("companies")
    public List<Company> getCompanies() {
        return companyService.findAll();
    }

    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("group", new Group());
        return "group/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Group group, BindingResult result) {
        if(result.hasErrors()) {
            return "group/add";
        }
        groupService.save(group);
        return "redirect:/group/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping(path="/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("group", groupService.findOne(id));
        return "group/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Valid Group group, BindingResult result) {
        if(result.hasErrors()) {
            return "group/edit";
        }
        groupService.save(group);
        return "redirect:/group/all";
    }

    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if(groupService.noContractsWithContractGroupId(id)) {
            groupService.delete(id);
            return "redirect:/group/all";
        } else {
            model.addAttribute("deleteError", true);
            model.addAttribute("groups", groupService.findAll());
            return "group/all";
        }

    }

    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("groups", groupService.findAll());
        return "group/all";
    }
}
