package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.service.ContractService;
import pl.coderslab.service.UserService;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/employee", produces = "text/html; charset=UTF-8")
@SessionAttributes("error")
public class EmployeeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;

    //all
    //*****************************************************************************
    @GetMapping("/view")
    public String all (Model model, HttpSession session) {
        Long insuredId = (Long) session.getAttribute("insuredId");
        System.out.println("zapisanie w empl contr" + insuredId.toString());
        model.addAttribute("user", userService.findOne(insuredId));
        model.addAttribute("contracts", contractService.findContractsByInsuredId(insuredId));
        return "employee/view";
    }

    @RequestMapping("/logout")
    public String logOut(Model model) {
        model.addAttribute("loggedUserType", "loggedOut");
        model.addAttribute("error", "3");
        return "redirect:/";
    }
}
