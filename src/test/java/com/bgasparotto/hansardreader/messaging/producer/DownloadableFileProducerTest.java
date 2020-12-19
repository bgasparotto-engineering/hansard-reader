package com.bgasparotto.hansardreader.messaging.producer;

import com.bgasparotto.filedownloader.message.DownloadableFile;
import com.bgasparotto.spring.kafka.avro.test.EmbeddedKafkaAvro;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@EmbeddedKafka
public class DownloadableFileProducerTest {

    @Autowired
    private EmbeddedKafkaAvro embeddedKafkaAvro;

    @Autowired
    private DownloadableFileProducer producer;

    @Value("${topics.output.downloadable-file}")
    private String topic;

    @Test
    public void shouldProduceUpdatedMessage() {
        DownloadableFile testMessage = buildTestMessage();
        producer.produce(testMessage);

        ConsumerRecord<String, DownloadableFile> consumedRecord = embeddedKafkaAvro.consumeOne(topic);
        assertThat(consumedRecord.key()).isEqualTo(testMessage.getId());
        assertThat(consumedRecord.value()).isEqualTo(testMessage);
    }

    private DownloadableFile buildTestMessage() {
        return DownloadableFile.newBuilder()
                .setId("some-test-id")
                .setTitle("Some Test Title")
                .setUri("some.uri.zip")
                .build();
    }
}
