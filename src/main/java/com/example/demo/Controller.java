package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @GetMapping(value = {"", "index", "/"})
    public ModelAndView index(ModelAndView mv) {
        mv.setViewName("index");
        return mv;
    }

}
