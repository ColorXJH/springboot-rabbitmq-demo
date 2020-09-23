package com.master.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/23 16:29
 */
//生产者
@Component
@Slf4j
public class Productor {
    @Autowired
    private AmqpTemplate template;

    public  String sendMessage(){
        String context="简单消息发送";
        log.info("简单消息发送时间: "+new Date());
        template.convertAndSend("message",context);
        return "发送成功";
    }
}
