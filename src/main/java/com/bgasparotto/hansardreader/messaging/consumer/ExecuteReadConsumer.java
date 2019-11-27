package com.bgasparotto.hansardreader.messaging.consumer;

import com.bgasparotto.scheduler.message.RunUpdate;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExecuteReadConsumer {

    @KafkaListener(topics = "message.scheduler.run-hansard-update")
    public void consume(ConsumerRecord<String, RunUpdate> record) {
        /* To be updated triggering the real API call. */
        log.info("Received command for updating Hansard data: [{}]", record.value());
    }
}
