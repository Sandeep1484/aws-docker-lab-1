package com.jb.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public String root() {
        return "App is running!!!";
    }

    @GetMapping("hi")
    public String hi(@RequestParam(defaultValue = "", required = false) String val) {
        return (val.isBlank() ? "Hello There!" : String.format("Hello %s!", val));
    }

}
