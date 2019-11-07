package com.flying.com.flying.controller;

import com.flying.service.com.flying.service.impl.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestServiceImpl testService;

    @RequestMapping("/getList")
    public List login(){
        return testService.getList();
    }

    @RequestMapping("/getMsg")
    public String getMSG () {
        return "this is my msg.";
    }
}
