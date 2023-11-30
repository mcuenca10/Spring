package com.example.app1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("example")
public class ExampleController {
    @RequestMapping(path = "Hello") //http://..../example/hello
    @ResponseBody
    public String Hello(){
        return "Hello";
    }
    @RequestMapping(path = "date") //http://..../example/hello
    @ResponseBody
    public LocalDateTime localDate(){

        return LocalDateTime.now();
    }


}
