package com.bgasparotto.hansardreader.messaging.producer;

import com.bgasparotto.scheduler.message.RunUpdate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Temporary producer for triggering calls to the Hansard API. <br/> The messages produced by this topic will be later
 * moved to another microservice.
 *
 * @author Bruno Gasparotto
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ExecuteReadProducer {
    private final KafkaTemplate<String, RunUpdate> kafkaTemplate;

    public void produce(RunUpdate runUpdate) {
        kafkaTemplate.send("message.scheduler.run-hansard-update", runUpdate.getDescription(), runUpdate);
        log.info("Produced command for updating Hansard data: [{}]", runUpdate);
    }
}
