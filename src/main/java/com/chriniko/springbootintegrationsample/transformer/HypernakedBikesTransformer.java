package com.chriniko.springbootintegrationsample.transformer;

import com.chriniko.springbootintegrationsample.dto.BikeInfo;
import com.chriniko.springbootintegrationsample.dto.RiderInfo;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

public class HypernakedBikesTransformer {

    public Message<BikeInfo> process(Message<RiderInfo> message) {

        System.out.println(" >>> HypernakedBikesTransformer#process: " + message);

        BikeInfo bikeInfo = new BikeInfo();
        bikeInfo.setMake("Yamaha");
        bikeInfo.setModel("MT-10");
        bikeInfo.setYear("2017");

        return MessageBuilder.withPayload(bikeInfo).copyHeadersIfAbsent(message.getHeaders()).build();
    }
}
