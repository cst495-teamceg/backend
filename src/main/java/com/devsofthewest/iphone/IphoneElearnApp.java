package com.devsofthewest.iphone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class IphoneElearnApp {
  public static void main(String[] args) {
     SpringApplication.run(IphoneElearnApp.class, args);
  }

  @GetMapping("/")
        public String hello() {
                return "Hello Spring Boot!";
        }
}

