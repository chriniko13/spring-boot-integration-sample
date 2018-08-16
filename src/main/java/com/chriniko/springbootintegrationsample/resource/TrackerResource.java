package com.chriniko.springbootintegrationsample.resource;

import com.chriniko.springbootintegrationsample.service.Tracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrackerResource {

    @Autowired
    private Tracker tracker;

    @GetMapping(value = "/tracker/messages")
    public List<String> messages() {
        return tracker.getMsgs();
    }

}
