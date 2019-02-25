package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.model.MainCover;
import pl.coderslab.service.MainCoverService;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/mainCover", produces = "text/html; charset=UTF-8")
public class MainCoverController {
    @Autowired
    private MainCoverService mainCoverService;

    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("mainCover", new MainCover());
        return "mainCover/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid MainCover mainCover, BindingResult result) {
        if(result.hasErrors()) {
            return "mainCover/add";
        }
        mainCoverService.save(mainCover);
        return "redirect:/mainCover/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping(path="/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("mainCover", mainCoverService.findOne(id));
        return "mainCover/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Valid MainCover mainCover, BindingResult result) {
        if(result.hasErrors()) {
            return "mainCover/edit";
        }
        mainCoverService.save(mainCover);
        return "redirect:/mainCover/all";
    }

    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        if (mainCoverService.noProductsWithMainCoverId(id)) {
            mainCoverService.delete(id);
            return "redirect:/mainCover/all";
        } else {
            model.addAttribute("deleteError", true);
            model.addAttribute("mainCovers", mainCoverService.findAll());
            return "mainCover/all";
        }
    }

    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("mainCovers", mainCoverService.findAll());
        return "mainCover/all";
    }
}
