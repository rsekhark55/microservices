package com.example.demo;

import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

    @GetMapping("/hello")
    @Timed(value = "hello.timer", description = "Time taken to execute hello endpoint")
    public String hello() {
        // Simulate some processing
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, Micrometer!";
    }
}
