package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(path = "/", produces = "text/html; charset=UTF-8")
    public String home() {
        return "home";
    }
}
