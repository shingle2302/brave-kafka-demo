package com.cns;

/**
 * @author zhangbin
 */
public class KafkaProducer {
    public static void main(String[] args) {
        ProducerThread producerThread = new ProducerThread(KafkaProperties.TOPIC, false);
        producerThread.start();
    }
}
