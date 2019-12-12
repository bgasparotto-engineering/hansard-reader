package com.bgasparotto.hansardreader.messaging.consumer;

import com.bgasparotto.hansardreader.service.HansardConsumerService;
import com.bgasparotto.scheduler.message.RunUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RunUpdateConsumer {
    private final HansardConsumerService hansardConsumerService;

    @KafkaListener(topics = "${topics.input.run-hansard-update}")
    public void consume(ConsumerRecord<String, RunUpdate> record) {
        log.info("Received command for updating Hansard data: [{}]", record.value());
        hansardConsumerService.queryFeed();
    }
}
