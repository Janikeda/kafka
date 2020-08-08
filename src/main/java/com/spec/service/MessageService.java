package com.spec.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class MessageService {

    private static final String TOPIC = "mymessages";

    public ProducerRecord<String, String> createRecord(String res) {
        return new ProducerRecord<>(TOPIC, res);
    }

    public void sendMessage(String message) {
        try (KafkaProducer<String, String> producer = new KafkaProducer<>(
            KafkaConfig.getConfig())) {
            producer.send(createRecord(message));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
