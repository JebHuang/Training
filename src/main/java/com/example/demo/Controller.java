package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class Controller {

    @GetMapping(value = {"", "index", "/"})
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("userName", "先生");
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "welcome")
    public ModelAndView welcome(ModelAndView mv) {
        mv.setViewName("welcome");
        return mv;
    }

    @GetMapping(value = "consult/table")
    public ModelAndView consultHandle(ModelAndView mv) {
        mv.setViewName("consult/table");
        return mv;
    }

    @GetMapping(value = "consult/add")
    public ModelAndView consultAdd(ModelAndView mv) {
        mv.setViewName("consult/add");
        return mv;
    }

    @GetMapping(value = "consult/edit")
    public ModelAndView consultEdit(ModelAndView mv) {
        mv.setViewName("consult/edit");
        return mv;
    }
}
