package com.ozgur.kafka.app.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;

//If you want to include this class, remove the comment line.
//@Component
public class KafkaConsumerWithAnswer {

    Logger LOG = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(
            groupId = "ozgur-group-1",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    @SendTo("ozgur-consumer-answer-topic")
    String listen1(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 1 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
        return "This is a reply sent after receiving message - group 1";
    }

    @KafkaListener(
            groupId = "ozgur-group-2",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    @SendTo("ozgur-consumer-answer-topic")
    String listen2(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 2 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
        return "This is a reply sent after receiving message - group 2";
    }

    @KafkaListener(
            groupId = "ozgur-group-3",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    @SendTo("ozgur-consumer-answer-topic")
    String listen3(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 3 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
        return "This is a reply sent after receiving message - group 3";
    }

    @KafkaListener(
            groupId = "ozgur-group-4",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    @SendTo("ozgur-consumer-answer-topic")
    String listen4(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Received message by group 4 - Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
        return "This is a reply sent after receiving message - group ";
    }

    @KafkaListener(
            groupId = "ozgur-consumer-answer-topic",
            topicPartitions = @TopicPartition(
                    topic = "ozgur-topic",
                    partitionOffsets = { @PartitionOffset(
                            partition = "0",
                            initialOffset = "0") }))
    void listenConsumerAnswer(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,
            @Header(KafkaHeaders.OFFSET) int offset) {
        LOG.info("Consumer's answers are consumed. Message:{} from partition - {} with offset - {}",
                message,
                partition,
                offset);
    }
}
