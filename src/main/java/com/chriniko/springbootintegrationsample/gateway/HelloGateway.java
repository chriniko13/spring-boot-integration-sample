package com.chriniko.springbootintegrationsample.gateway;

import com.chriniko.springbootintegrationsample.dto.Name;

public interface HelloGateway {

    String getMessage(Name name);
}
