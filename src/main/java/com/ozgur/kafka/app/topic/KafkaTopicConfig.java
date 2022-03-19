package com.ozgur.kafka.app.topic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${ozgur.kafka.topic}")
    private String topic;

    @Bean
    NewTopic topic1() {
        return TopicBuilder.name(topic).build();
    }

    @Bean
    NewTopic topic2() {
        return TopicBuilder.name("ozgur-consumer-answer-topic").build();
    }
}
