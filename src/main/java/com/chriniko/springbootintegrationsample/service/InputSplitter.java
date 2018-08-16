package com.chriniko.springbootintegrationsample.service;

import com.chriniko.springbootintegrationsample.dto.Input;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class InputSplitter {

    public static final String TX_ID = "TX_ID";

    public List<Message<Input>> process(Message<Input> incoming) {

        UUID correlationId = UUID.randomUUID();

        return Arrays.asList(
                MessageBuilder.fromMessage(incoming).setHeader(TX_ID, correlationId).build(),
                MessageBuilder.fromMessage(incoming).setHeader(TX_ID, correlationId).build(),
                MessageBuilder.fromMessage(incoming).setHeader(TX_ID, correlationId).build()
        );

    }
}
