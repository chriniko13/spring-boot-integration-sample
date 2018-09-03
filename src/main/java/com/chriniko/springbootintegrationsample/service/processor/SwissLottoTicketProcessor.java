package com.chriniko.springbootintegrationsample.service.processor;

import com.chriniko.springbootintegrationsample.dto.SwissLotto;
import org.springframework.messaging.Message;

public class SwissLottoTicketProcessor {

    public Message<SwissLotto> process(Message<SwissLotto> swissLottoMessage) {
        System.out.println("    >>>SwissLottoTicketProcessor#process --- message: " + swissLottoMessage.getPayload());
        return swissLottoMessage;
    }
}
