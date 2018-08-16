package com.chriniko.springbootintegrationsample.release;

import org.springframework.integration.aggregator.ReleaseStrategy;
import org.springframework.integration.store.MessageGroup;

public class InputReleaseStrategy implements ReleaseStrategy {

    @Override
    public boolean canRelease(MessageGroup group) {
        return group.size() == 5;
    }
}
