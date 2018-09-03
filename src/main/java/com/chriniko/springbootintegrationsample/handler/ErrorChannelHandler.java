package com.chriniko.springbootintegrationsample.handler;

import org.springframework.messaging.Message;

public class ErrorChannelHandler {

    public void handle(Message<?> message) {
        System.out.println("    >>> ErrorChannelHandler#handle, message: " + message);
    }
}
