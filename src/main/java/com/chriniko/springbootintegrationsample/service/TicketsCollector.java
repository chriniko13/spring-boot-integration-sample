package com.chriniko.springbootintegrationsample.service;

import com.chriniko.springbootintegrationsample.dto.DrawInfo;
import com.chriniko.springbootintegrationsample.dto.Ticket;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.List;
import java.util.stream.Collectors;

public class TicketsCollector {

    private final WinningRandomSelection winningRandomSelection;

    public TicketsCollector(WinningRandomSelection winningRandomSelection) {
        this.winningRandomSelection = winningRandomSelection;
    }

    public Message<List<Ticket>> process(List<Message<Ticket>> messages) {

        List<Ticket> processedTickets = messages
                .stream()
                .map(Message::getPayload)
                .map(winningRandomSelection::process)
                .collect(Collectors.toList());

        DrawInfo drawInfo = (DrawInfo) messages.iterator().next().getHeaders().get(RandomTicketCreator.DRAW_INFO);

        return MessageBuilder
                .withPayload(processedTickets)
                .setHeader(RandomTicketCreator.DRAW_INFO, drawInfo)
                .build();

    }
}
