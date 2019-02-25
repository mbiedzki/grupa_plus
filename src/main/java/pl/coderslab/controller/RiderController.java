package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.Rider;
import pl.coderslab.service.RiderService;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/rider", produces = "text/html; charset=UTF-8")
public class RiderController {
    @Autowired
    private RiderService riderService;

    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("rider", new Rider());
        return "rider/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Rider rider, BindingResult result) {
        if(result.hasErrors()) {
            return "rider/add";
        }
        riderService.save(rider);
        return "redirect:/rider/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping(path="/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("rider", riderService.findOne(id));
        return "rider/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Valid Rider rider, BindingResult result) {
        if(result.hasErrors()) {
            return "rider/edit";
        }
        riderService.save(rider);
        return "redirect:/rider/all";
    }

    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (riderService.noProductsWithRiderId(id)) {
            riderService.delete(id);
            return "redirect:/rider/all";
        } else {
            model.addAttribute("deleteError", true);
            model.addAttribute("riders", riderService.findAll());
            return "rider/all";
        }
    }

    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("riders", riderService.findAll());
        return "rider/all";
    }
}
