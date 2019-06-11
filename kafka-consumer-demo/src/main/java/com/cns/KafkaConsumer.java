package com.cns;

/**
 * @author zhangbin
 */
public class KafkaConsumer {
    public static void main(String[] args) {
        ConsumerThread consumerThread = new ConsumerThread(KafkaProperties.TOPIC);
        consumerThread.start();
    }
}
