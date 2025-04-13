package com.microstore.microservices.notification.service;

import com.microstore.microservices.order.event.OrderPlacedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    @KafkaListener(topics = "order-placed")
    public void listen(OrderPlacedEvent orderPlacedEvent) {
        log.info("Got Message from order-placed topic {}", orderPlacedEvent);


        // Simulate sending email
        String demo_email = String.format("""
                
                --------------------------------
                From: shop@microstore.com
                To: %s
                -------------------------------
                Hi,
                
                Your order with order number %s is now placed successfully.
                
                Best Regards
                MicroStore
                --------------------------------
                """, orderPlacedEvent.getEmail(), orderPlacedEvent.getOrderNumber());
        log.info(demo_email);
    }
}