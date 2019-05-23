package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("/home")
    public String doIt(Model model) {
        model.addAttribute("name", "Spring Boot");
        return "welcome";
    }
}
