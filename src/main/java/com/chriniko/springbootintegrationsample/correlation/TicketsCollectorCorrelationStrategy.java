package com.chriniko.springbootintegrationsample.correlation;

import org.springframework.integration.aggregator.CorrelationStrategy;
import org.springframework.messaging.Message;

public class TicketsCollectorCorrelationStrategy implements CorrelationStrategy {

    @Override
    public Object getCorrelationKey(Message<?> message) {
        return message.getHeaders().get("correlationId");
    }
}
