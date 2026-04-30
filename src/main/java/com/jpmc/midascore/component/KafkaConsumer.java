package com.jpmc.midascore.component;

// correct import prevents compilation error
import com.jpmc.midascore.foundation.Transaction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

// @Component > makes Spring detect your class
@Component
public class KafkaConsumer {
    private final DatabaseConduit databaseConduit;

    public KafkaConsumer(DatabaseConduit databaseConduit) {
        this.databaseConduit = databaseConduit;
    }

    // Transaction import > needed for deserialization
    @KafkaListener(topics = "${general.kafka-topic}")
    public void listen(Transaction transaction) {
        databaseConduit.processTransaction(transaction);
    }
}
