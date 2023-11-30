package com.example.app1.controllers;

import com.example.app1.models.CompraForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class PagesControllers {
    @GetMapping
    public String home(Model model){
        model.addAttribute("nombre", "Mario" );
        model.addAttribute("nombres", Map.of(1, "uno", 2, "dos"));
        return "home";
    }
    @GetMapping("compra")
    public String compra(Model model){
        model.addAttribute("compra", new CompraForm(10.0,""));
        return "compra";
    }

    @PostMapping("compra")
    public String compra(Model model, CompraForm compra){
        System.out.println(compra);
        return "compra";
    }

 /*   @GetMapping
    public ModelAndView home2(){
         var model= new ModelAndView("home" );
         model.addAllObjects("nombre", "Msrio");
        return "home";
    }*/
}
