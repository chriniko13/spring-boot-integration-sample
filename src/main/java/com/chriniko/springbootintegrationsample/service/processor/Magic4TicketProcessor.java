package com.chriniko.springbootintegrationsample.service.processor;

import com.chriniko.springbootintegrationsample.dto.Magic4;
import org.springframework.messaging.Message;

public class Magic4TicketProcessor {

    public Message<Magic4> process(Message<Magic4> magic4Message) {
        System.out.println("    >>>Magic4TicketProcessor#process --- message: " + magic4Message.getPayload());
        return magic4Message;
    }
}
