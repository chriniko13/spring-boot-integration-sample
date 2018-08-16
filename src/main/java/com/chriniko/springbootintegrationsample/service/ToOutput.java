package com.chriniko.springbootintegrationsample.service;

import com.chriniko.springbootintegrationsample.dto.Output;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.Message;

import java.util.List;
import java.util.stream.Collectors;

public class ToOutput {

    private final ObjectMapper objectMapper;

    public ToOutput(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Output process(List<Message<?>> incoming) {

        List<Output.Pair> payloads = incoming
                .stream()
                .map(Message::getPayload)
                .map(p -> {
                    try {

                        Output.Pair pair = new Output.Pair();
                        pair.setType(p.getClass().getSimpleName());
                        pair.setValue(objectMapper.writeValueAsString(p));

                        return pair;
                    } catch (JsonProcessingException e) {
                        return null;
                    }
                })
                .collect(Collectors.toList());

        Output output = new Output();
        output.setResults(payloads);
        return output;
    }
}
