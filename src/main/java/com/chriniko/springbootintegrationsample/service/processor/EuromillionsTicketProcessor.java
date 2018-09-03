package com.chriniko.springbootintegrationsample.service.processor;

import com.chriniko.springbootintegrationsample.dto.Euromillions;
import org.springframework.messaging.Message;

public class EuromillionsTicketProcessor {

    public Message<Euromillions> process(Message<Euromillions> euromillionsMessage) {
        System.out.println("    >>>EuromillionsTicketProcessor#process --- message: " + euromillionsMessage.getPayload());
        return euromillionsMessage;
    }
}
