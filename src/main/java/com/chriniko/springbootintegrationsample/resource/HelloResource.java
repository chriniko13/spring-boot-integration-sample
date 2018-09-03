package com.chriniko.springbootintegrationsample.resource;

import com.chriniko.springbootintegrationsample.dto.Input;
import com.chriniko.springbootintegrationsample.dto.Name;
import com.chriniko.springbootintegrationsample.dto.Output;
import com.chriniko.springbootintegrationsample.gateway.HelloGateway;
import com.chriniko.springbootintegrationsample.gateway.SampleGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloResource {

    private final HelloGateway helloGateway;
    private final SampleGateway sampleGateway;

    @Autowired
    public HelloResource(HelloGateway helloGateway, SampleGateway sampleGateway) {
        this.helloGateway = helloGateway;
        this.sampleGateway = sampleGateway;
    }

    // Note: 1st usage example.
    @RequestMapping(
            value = "/hello",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    HttpEntity<String> sayHello(@RequestBody Name name) {
        String message = helloGateway.getMessage(name);
        return ResponseEntity.ok(message);
    }

    // Note: 2nd usage example.
    @RequestMapping(
            value = "/sample",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public @ResponseBody
    HttpEntity<Output> sayHello(@RequestBody Input input) {
        Output output = sampleGateway.process(input);
        return ResponseEntity.ok(output);
    }

}
