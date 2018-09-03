package com.chriniko.springbootintegrationsample.service;

import com.chriniko.springbootintegrationsample.dto.Ticket;

import java.util.concurrent.ThreadLocalRandom;

public class WinningRandomSelection {

    public Ticket process(Ticket ticket) {
        int num = ThreadLocalRandom.current().nextInt(0, 2);
        String result = num == 0 ? "LOSE" : "WIN";
        ticket.setOutcome(result);
        return ticket;
    }
}
