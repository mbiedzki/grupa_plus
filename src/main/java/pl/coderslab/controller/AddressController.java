package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Address;
import pl.coderslab.service.AddressService;
import javax.validation.Valid;

/*
@Controller
@RequestMapping(path="/address", produces = "text/html; charset=UTF-8")
public class AddressController {
    @Autowired
    private AddressService addressService;

    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("address", new Address());
        return "address/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Address address, BindingResult result) {
        if(result.hasErrors()) {
            return "address/add";
        }
        addressService.save(address);
        return "redirect:/address/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping(path="/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("address", addressService.findOne(id));
        return "address/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Valid Address address, BindingResult result) {
        if(result.hasErrors()) {
            return "address/edit";
        }
        addressService.save(address);
        return "redirect:/address/all";
    }

    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        addressService.delete(id);
        return "redirect:/address/all";

    }

    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("addresses", addressService.findAll());
        return "address/all";
    }
}
*/
