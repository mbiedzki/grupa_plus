package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.MainCover;
import pl.coderslab.model.Product;
import pl.coderslab.model.Rider;
import pl.coderslab.service.MainCoverService;
import pl.coderslab.service.ProductService;
import pl.coderslab.service.RiderService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/product", produces = "text/html; charset=UTF-8")
@SessionAttributes({"deleteError"})
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private MainCoverService mainCoverService;
    @Autowired
    private RiderService riderService;

    @ModelAttribute("mainCovers")
    public List<MainCover> getMainCovers() {
        return mainCoverService.findAll();
    }

    @ModelAttribute("riderList")
    public List<Rider> getRiders() {
        return riderService.findAll();
    }

    //add
    //*****************************************************************************
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping(path = "/add")
    public String add(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/add";
        }
        productService.save(product);
        return "redirect:/product/all";
    }

    //edit
    //*****************************************************************************
    @GetMapping(path = "/edit/{id}")
    public String edit(Model model, @PathVariable Long id) {
        model.addAttribute("product", productService.findOne(id));
        return "product/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String save(@Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "product/edit";
        }
        productService.save(product);
        return "redirect:/product/all";
    }

    //delete
    //*****************************************************************************
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable Long id) {
        if (productService.noGroupsWithProductId(id)) {
            productService.delete(id);
            return "redirect:/product/all";
        } else {
            model.addAttribute("deleteError", true);
            model.addAttribute("products", productService.findAll());
            return "redirect:/product/all";
        }

    }


    //all
    //*****************************************************************************
    @RequestMapping("/all")
    public String all(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product/all";
    }

}
