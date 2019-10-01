package be.vdab.groenetenen.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/")
public class IndexController {
    private String begroeting(){
        int uur = LocalDateTime.now().getHour();
        if(uur >= 6 && uur < 12){
            return "goede morgen";
        } else if (uur >= 12 && uur < 18) {
            return "goede middag";
        } else {
            return "goede avond";
        }
    }

    @GetMapping
    public ModelAndView index(){
        return new ModelAndView("index",  "begroeting", begroeting());

    }
}
