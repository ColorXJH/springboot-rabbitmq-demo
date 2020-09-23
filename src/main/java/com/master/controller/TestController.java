package com.master.controller;

import com.master.beans.Productor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ColorXJH
 * @version 1.0
 * @description 测试springboot整合rabbitmq小案例
 * @date 2020/9/23 16:20
 */
@RestController
public class TestController {
    @Autowired
    private Productor productor;

    @GetMapping("/testMyDemo")
    public String testMyDemo(){
        productor.sendMessage();
        return "success";
    }
    @GetMapping("/ready")
    public String ready(){
        return "ready to statup";
    }

}
