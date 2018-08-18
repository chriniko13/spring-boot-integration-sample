package com.chriniko.springbootintegrationsample.handler;

import org.springframework.util.ErrorHandler;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class PubSubChannelErrorHandler implements ErrorHandler {

    // Note: in a real system, a subscriber will consume errors from this
    //       queue and based on the criteria it has, it will replay it, or
    //       discard it, or escalate it to support engineers.
    public Queue<Throwable> errorsOccurred = new LinkedBlockingQueue<>();

    @Override
    public void handleError(Throwable t) {

        System.err.println("    >>>PubSubChannelErrorHandler#handleError, error occurred: " + t);

        errorsOccurred.add(t);
    }

}
