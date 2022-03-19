package com.ozgur.kafka.app.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
class InitSend {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaProducer kafkaProducer;


    @Value("${ozgur.kafka.topic}")
    private String topic;

    @EventListener
    void initiateSendingMessage(ApplicationReadyEvent event) throws InterruptedException {
        Thread.sleep(5000);
        LOG.info("---------------------------------");
        kafkaProducer.sendMessage("1. Hello World", topic);

        Thread.sleep(5000);
        LOG.info("---------------------------------");
        kafkaProducer.sendMessage("2. Hello World", topic);

        Thread.sleep(5000);
        LOG.info("---------------------------------");
        kafkaProducer.sendMessageWithCallback("1. I'll get a asyc Callback", topic);

        Thread.sleep(5000);
        LOG.info("---------------------------------");
        kafkaProducer.sendMessageWithCallback("2. I'll get a asyc Callback", topic);


    }
}
