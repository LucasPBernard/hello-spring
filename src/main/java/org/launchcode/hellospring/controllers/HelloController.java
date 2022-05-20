package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//@ResponseBody

@Controller
public class HelloController {
//        Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST,},value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model, @RequestParam String language) {
        String properGreeting = HelloController.createMessage(name, language);
        model.addAttribute("properGreeting", properGreeting);
        return "hello";
    }

    // Handles request of the form /hello/LaunchCode

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model, String language) {
        String properGreeting = HelloController.createMessage(name, language);
        model.addAttribute("properGreeting", properGreeting);
        return "hello";
    }


    @GetMapping("form")
    public String helloForm() {
        return "form";
    }


    public static  String createMessage(String name, String language) {
        switch (language) {
            case "Spanish":
                return "Hola, " + name;
            case "French":
                return "Bonjour, " + name;
            case "Italian":
                return "Ciao, " + name;
            case "German":
                return "Hallo, " + name;
            case "English":
            default:
                return "Hello, " + name;
        }
    }
}
