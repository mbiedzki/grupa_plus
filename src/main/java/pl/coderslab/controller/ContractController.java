package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Contract;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;
import pl.coderslab.service.ContractService;
import pl.coderslab.service.GroupService;
import pl.coderslab.service.UserService;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping(path = "/contract", produces = "text/html; charset=UTF-8")
@SessionAttributes({"deleteError"})
public class ContractController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private UserService userService;
    @Autowired
    private GroupService groupService;

    @ModelAttribute("insureds")
    public List<User> getInsureds() {
        return userService.findAll();
    }

    @ModelAttribute("beneficiaries")
    public List<User> getBeneficiaries() {
        return userService.findAll();
    }

    @ModelAttribute("contractGroups")
    public List<Group> getContractGroups() {
        return groupService.findAll();
    }


    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Contract contract, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return "contract/add";
        }
        LocalDateTime date = LocalDateTime.now();
        contract.setCreated(date);
        contractService.save(contract);
        return "redirect:/contract/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("contract", contractService.findOne(id));
        return "contract/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Valid Contract contract, BindingResult result, Model model) throws IOException {
        if (result.hasErrors()) {
            return "contract/edit";
        }
        contractService.save(contract);
        return "redirect:/contract/all";
    }

    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        contractService.delete(id);
        return "redirect:/contract/all";

    }

    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("contracts", contractService.findAll());
        return "contract/all";
    }
}
