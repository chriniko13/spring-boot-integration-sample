package com.chriniko.springbootintegrationsample.transformer;

import com.chriniko.springbootintegrationsample.dto.Name;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.support.MessageBuilder;

public class HelloWorld {

    public Message<String> process(Message<Name> message, @Header("SHOULD_UPPERCASE") boolean shouldUppercase) {

        System.out.println("    >>>HelloWorld#process: " + message);

        String name = message.getPayload().getName();
        if (shouldUppercase) {
            name = name.toUpperCase();
        }

        return MessageBuilder.withPayload("Hello " + name + "!!!")
                .copyHeadersIfAbsent(message.getHeaders())
                .build();
    }
}
