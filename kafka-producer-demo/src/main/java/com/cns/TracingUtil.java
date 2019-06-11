package com.cns;

import brave.Tracing;
import brave.kafka.clients.KafkaTracing;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.urlconnection.URLConnectionSender;
import brave.Tracer;
/**
 * @author zhangbin
 */


/**
 * @author zhangbin
 */

public class TracingUtil {

    private static AsyncReporter asyncReporter;

    private static Tracing tracing;

    private static KafkaTracing kafkaTracing;

    public static AsyncReporter getAsyncReporter() {
        return asyncReporter;
    }

    public static Tracer getTracer() {
        return tracing.tracer();
    }

    public static KafkaTracing getKafkaTracing() {
        Sender sender = URLConnectionSender.create("http://127.0.0.1:9411/api/v2/spans");
        asyncReporter = AsyncReporter.create(sender);
        if (null == tracing) {
            tracing = Tracing.newBuilder()
                    .localServiceName("kafka-producer-demo")
                    .spanReporter(asyncReporter)
                    .build();
            kafkaTracing = KafkaTracing.newBuilder(tracing).remoteServiceName("my-broker").writeB3SingleFormat(true).build();
        }
        return kafkaTracing;
    }
}

