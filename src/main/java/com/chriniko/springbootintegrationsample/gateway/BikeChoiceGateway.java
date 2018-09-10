package com.chriniko.springbootintegrationsample.gateway;

import com.chriniko.springbootintegrationsample.dto.BikeInfo;
import com.chriniko.springbootintegrationsample.dto.RiderInfo;

public interface BikeChoiceGateway {

    BikeInfo process(RiderInfo riderInfo);
}
