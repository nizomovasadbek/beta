package uz.beta.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeniedController {

    @GetMapping("/denied")
    public String getDenied(){
        return "<h1>Page Access Denied</h1>";
    }

}
