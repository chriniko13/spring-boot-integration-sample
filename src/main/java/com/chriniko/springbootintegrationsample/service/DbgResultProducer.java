package com.chriniko.springbootintegrationsample.service;

import com.chriniko.springbootintegrationsample.dto.DbgResult;
import com.chriniko.springbootintegrationsample.dto.DrawInfo;
import com.chriniko.springbootintegrationsample.dto.Ticket;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class DbgResultProducer {

    public Message<DbgResult> produce(Message<List<Ticket>> message) {

        System.out.println("    >>>DbgResultProducer#produce, message: " + message);

        List<Ticket> payload = message.getPayload();

        DrawInfo drawInfo = (DrawInfo) message.getHeaders().get(RandomTicketCreator.DRAW_INFO);

        DbgResult dbgResult = new DbgResult();
        dbgResult.setDrawInfo(drawInfo);
        dbgResult.setWinTickets(payload);
        dbgResult.setGroupingByOutcome(
                payload
                        .stream()
                        .collect(Collectors.groupingBy(Ticket::getOutcome))
        );

        return MessageBuilder
                .withPayload(dbgResult)
                .copyHeadersIfAbsent(message.getHeaders())
                .build();
    }
}
