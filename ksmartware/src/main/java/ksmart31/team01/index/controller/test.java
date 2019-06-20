package ksmart31.team01.index.controller;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class test {
    

    
    @GetMapping("/2")
    public String index2() {
    
    return "test3";
    }
    
    
}
