package com.chriniko.springbootintegrationsample.service.processor;

import com.chriniko.springbootintegrationsample.dto.TrioMagic;
import org.springframework.messaging.Message;

public class TrioMagicTicketProcessor {

    public Message<TrioMagic> process(Message<TrioMagic> trioMagicMessage) {
        System.out.println("    >>>TrioMagicTicketProcessor#process --- message: " + trioMagicMessage.getPayload());
        return trioMagicMessage;
    }
}
