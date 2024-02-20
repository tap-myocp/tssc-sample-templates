package org.acme;

import io.smallrye.reactive.messaging.kafka.Record;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DemoProducer {

    @Inject @Channel("demo-out")
    Emitter<Record<Integer, String>> emitter;

    public void sendMessageToKafka(String message) {
        emitter.send(Record.of(1, message));
    }
}