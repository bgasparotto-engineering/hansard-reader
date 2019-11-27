package com.bgasparotto.hansardreader.controller;

import com.bgasparotto.hansardreader.messaging.producer.ExecuteReadProducer;
import com.bgasparotto.scheduler.message.RunUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/management")
@RequiredArgsConstructor
public class ExecuteReadController {
    private final ExecuteReadProducer producer;

    @GetMapping(value = "/run-update")
    public void sendMessageToKafkaTopic() {
        RunUpdate message = RunUpdate.newBuilder()
                .setDescription("Manually triggered Hansard update from temporary API")
                .build();
        this.producer.produce(message);
    }
}
