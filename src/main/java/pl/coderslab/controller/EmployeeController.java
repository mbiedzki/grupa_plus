package pl.coderslab.controller;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pl.coderslab.model.Contract;
import pl.coderslab.model.User;
import pl.coderslab.service.ContractService;
import pl.coderslab.service.UserService;
import pl.coderslab.util.Mailer;
import pl.coderslab.util.PdfCreator;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/employee", produces = "text/html; charset=UTF-8")
@SessionAttributes({"error", "userId", "emailSent"})
public class EmployeeController {
    @Autowired
    private UserService userService;
    @Autowired
    private ContractService contractService;

    //employee view
    //*****************************************************************************
    @GetMapping("/view")
    public String all (Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        model.addAttribute("user", userService.findOne(userId));
        model.addAttribute("contracts", contractService.findContractsByInsuredId(userId));
        return "employee/view";
    }

    @PostMapping("/view")
    public String send(@RequestParam String emailToSend, Model model, HttpSession session)
            throws IOException, DocumentException {
        Long userId = (Long) session.getAttribute("userId");
        userService.buildPdf(userId);
        Mailer.send(emailToSend, "Grupa Plus - Twoje umowy.",
                "GRUPA PLUS, poniżej załączamy Twoje umowy\nPozdrawiamy.\n\n");
        model.addAttribute("emailSent", true);
        return "redirect:/employee/view";
    }


    @RequestMapping("/logout")
    public String logOut(Model model, HttpSession session, SessionStatus status) {
        model.addAttribute("loggedUserType", "loggedOut");
        model.addAttribute("error", "3");
        status.setComplete();
        session.invalidate();
        return "redirect:/";
    }

}
