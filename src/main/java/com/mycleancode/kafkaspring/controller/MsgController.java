package com.mycleancode.kafkaspring.controller;

import com.mycleancode.kafkaspring.dto.Address;
import com.mycleancode.kafkaspring.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
@RequiredArgsConstructor
public class MsgController {

    private final KafkaTemplate<Long, UserDto> kafkaTemplate;

    @PostMapping
    public void sendMsg(Long msgId, UserDto msg) {
        msg.setAddress(new Address("Russia", "Spb", "Lenina", 112L, 584L));
        ListenableFuture<SendResult<Long, UserDto>> future = kafkaTemplate.send("msg", msgId, msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}
