package com.chriniko.springbootintegrationsample.resource;

import com.chriniko.springbootintegrationsample.dto.BikeInfo;
import com.chriniko.springbootintegrationsample.dto.RiderInfo;
import com.chriniko.springbootintegrationsample.gateway.BikeChoiceGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class BikeResource {

    private final BikeChoiceGateway bikeChoiceGateway;

    @Autowired
    public BikeResource(BikeChoiceGateway bikeChoiceGateway) {
        this.bikeChoiceGateway = bikeChoiceGateway;
    }

    @RequestMapping(
            value = "/bikes",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    BikeInfo get(@RequestBody RiderInfo riderInfo) {
        return bikeChoiceGateway.process(riderInfo);
    }

}
