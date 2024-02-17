package net.javaguides.springbootrestapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody // -> to convert java object into json then object to json and HttpResponse
@RestController // -> combination of controller and responseBody
public class HelloWorldController {
    // HTTP GET Request
    // http://localhost:8080/hello-world
    @GetMapping("/hello-world") //-> used to map http get request onto specific handler
    public String helloWorld(){
        return "Hello World!";
    }
}
