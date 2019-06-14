package com.cns;

/**
 * @author zhangbin
 */
public class KafkaProducer {
    public static void main(String[] args) throws InterruptedException {
        ProducerThread producerThread = new ProducerThread(KafkaProperties.TOPIC, false);
        producerThread.start();
        Thread.sleep(1_000);
    }
}
