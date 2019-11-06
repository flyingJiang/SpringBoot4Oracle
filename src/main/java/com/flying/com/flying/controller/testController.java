package com.flying.com.flying.controller;

import com.flying.service.com.flying.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class testController {

    @Autowired
    private TestServiceImpl testService;

    @RequestMapping("/getList")
    public List login(){
        return testService.getList();
    }
}
