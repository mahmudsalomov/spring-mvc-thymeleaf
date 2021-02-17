package uz.pdp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String hello2(){
//        return "hello";
//    }

}
