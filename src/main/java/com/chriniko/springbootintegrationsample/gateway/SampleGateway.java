package com.chriniko.springbootintegrationsample.gateway;

import com.chriniko.springbootintegrationsample.dto.Input;
import com.chriniko.springbootintegrationsample.dto.Output;

public interface SampleGateway {

    Output process(Input input);
}
