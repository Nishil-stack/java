package com.spring.framework.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restController {
    @GetMapping("/")
    public String fuckingFirstHelu(){
        return "Helu";
    }
}
