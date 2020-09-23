package com.master.beans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author ColorXJH
 * @version 1.0
 * @description
 * @date 2020/9/23 16:37
 */
@Component
@Slf4j
@RabbitListener(queues = "message")
public class Consumer {
    //1. 需要在rabbitmq中手动创建队列，否则报错（也可以不写队列名，使用默认值）
    @RabbitListener(queues = "message")
    //2. 自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("myQueue2"))
    //3. 自动创建队列，Exchange 与 Queue绑定
    /*@RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue3"),
            exchange = @Exchange("testExChange")
    ))*/
    @RabbitHandler
    public void receiveMessage(String context){
        log.info("接收到消息: "+context);
        log.info("接收到消息时间: "+new Date());
    }
}
