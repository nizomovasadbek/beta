package uz.beta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    @GetMapping("/dashboard")
    public String DashboardPage(){
        return "<a href=\"/logout\">" +
                "<input type=\"button\" value=\"Logout\"></a>";
    }
}
