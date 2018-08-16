package com.chriniko.springbootintegrationsample.interceptor;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;

public class IncomingChannelInterceptor implements ChannelInterceptor {

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        System.out.printf("preSend --- message: %s --- channel: %s\n", message, channel);
        return message;
    }

    @Override
    public void postSend(Message<?> message, MessageChannel channel, boolean sent) {
        System.out.printf("postSend --- message: %s --- channel: %s --- sent: %s\n", message, channel, sent);

    }

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        System.out.printf("afterSendCompletion --- message: %s --- channel: %s --- sent: %s --- ex: %s\n", message, channel, sent, ex);
    }

    @Override
    public boolean preReceive(MessageChannel channel) {
        System.out.printf("preReceive --- channel: %s\n", channel);
        return true;
    }

    @Override
    public Message<?> postReceive(Message<?> message, MessageChannel channel) {
        System.out.printf("postSend --- message: %s --- channel: %s\n", message, channel);
        return message;
    }

    @Override
    public void afterReceiveCompletion(Message<?> message, MessageChannel channel, Exception ex) {
        System.out.printf("afterReceiveCompletion --- message: %s --- channel: %s --- ex: %s\n", message, channel, ex);
    }
}
