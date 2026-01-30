package com.nutrihub.order_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.TopicForRetryable;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic orderPlacedTopic(){
        return new NewTopic("order-placed-topic",3,(short)1);
    }

    @Bean
    public NewTopic orderPlacedDataTopic(){
        return new NewTopic("order-placed-data-topic",3,(short)1);
    }
}
