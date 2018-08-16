package com.chriniko.springbootintegrationsample.service;

import org.springframework.messaging.Message;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Tracker {

    private List<String> msgs;

    void init() {
        msgs = Collections.synchronizedList(new LinkedList<>());
    }

    public void perform(Message<String> msg) {
        System.out.println("    >>>Tracker#perform, just fired, message: " + msg);
        msgs.add(msg.getPayload());
    }

    public List<String> getMsgs() {
        return msgs;
    }
}
