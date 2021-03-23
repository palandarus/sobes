package ru.geekbrains.hwlsix.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(method = RequestMethod.GET)
    public String incommingGetRequest(){
        System.out.println("incoming get request");
        return "incomming get request";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String incommingPostRequest(){
        System.out.println("incoming post request");
        return "incoming post request";
    }

}
