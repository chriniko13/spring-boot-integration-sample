package com.chriniko.springbootintegrationsample.release;

import com.chriniko.springbootintegrationsample.service.RandomTicketCreator;
import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;

public class TicketsCollectorReleaseStrategy implements ReleaseStrategy {
    @Override
    public boolean canRelease(MessageGroup group) {

        int groupSize = group.size();
        return groupSize == RandomTicketCreator.NO_OF_TICKETS;
    }
}
