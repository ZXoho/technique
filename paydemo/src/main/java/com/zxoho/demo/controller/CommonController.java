package com.zxoho.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Project: paydemo
 * Created by admin on 2018/12/8 15:09
 */
@Controller
@RequestMapping("/common")
public class CommonController {

    @GetMapping("/getIndexPage")
    public ModelAndView getIndexPage(){
        return new ModelAndView("index");
    }

    @GetMapping("/getContractPage")
    public ModelAndView getContractPage() {
        return new ModelAndView("/contract/contract");
    }

}
