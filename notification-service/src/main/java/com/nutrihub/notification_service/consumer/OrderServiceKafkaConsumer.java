package com.nutrihub.notification_service.consumer;

import com.nutrihub.notification_service.order_service.event.OrderPlacedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceKafkaConsumer {

    @KafkaListener(topics = "order-placed-topic")
    public void handleOrderPlacedTopic(String message){
        log.info("message received: {}",message);
    }

    @KafkaListener(topics = "order-placed-data-topic")
    public void handleOrderPlacedDataTopic(OrderPlacedEvent orderPlacedEvent){
        log.info("message received: {}",orderPlacedEvent.toString());
    }


}
