package com.ripjava.spring.mvc.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ModelController {
    @GetMapping("passByModel")
    public String passParametersWithModel(Model model) {
        model.addAttribute("message", "by model");
        return "viewPage";
    }

    @GetMapping("/passByModelMap")
    public String passParametersWithModelMap(ModelMap map) {
        map.addAttribute("welcomeMessage", "welcome by ModelMap");
        map.addAttribute("message", "by ModelMap");
        return "viewPage";
    }

    @GetMapping("/passByModelAndView")
    public ModelAndView passParametersWithModelAndView() {
        ModelAndView modelAndView = new ModelAndView("viewPage");
        modelAndView.addObject("message", "by ModelAndView");
        return modelAndView;
    }
}
