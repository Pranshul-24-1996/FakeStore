package com.example.ProductService.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    // Endpoint name: Get /hello
    @GetMapping("/hello")
    public String helloWorld() {
        return  "Hello World";
    }

    //Endpoint name: Get /hello/{name}
    @GetMapping("/hello/{name}")
    public String helloWithName(@PathVariable("name") String name) {
        return "Hello " + name;
    }

    //Endpoint name" Get /name/{name}/jobTitle/{jobTitle}
    @GetMapping("/hello/{name}/{jobTitle}")
    public String helloNameWithJobtitle(@PathVariable("name") String name, @PathVariable("jobTitle") String jobTitle) {
        return "Hello " + name + ", you are " + jobTitle;
    }
}
