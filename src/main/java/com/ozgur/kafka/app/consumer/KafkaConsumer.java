package com.ozgur.kafka.app.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            groupId = "ozgur-group-1",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    void listen1(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 1 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
    }

    @KafkaListener(
            groupId = "ozgur-group-2",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    void listen2(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 2 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
    }

    @KafkaListener(
            groupId = "ozgur-group-3",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    void listen3(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 3 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
    }

    @KafkaListener(
            groupId = "ozgur-group-4",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    void listen4(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 4 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
    }
}
