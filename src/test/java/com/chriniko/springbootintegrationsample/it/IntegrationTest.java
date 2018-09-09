package com.chriniko.springbootintegrationsample.it;

import com.chriniko.springbootintegrationsample.SpringBootIntegrationSampleApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = SpringBootIntegrationSampleApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public abstract class IntegrationTest {

    @LocalServerPort
    protected Integer apiPort;

    @Autowired
    protected RestTemplate restTemplate;

    @Autowired
    protected ObjectMapper objectMapper;

    protected String loadResource(String resourceName) throws Exception {
        URL resource = this.getClass().getClassLoader().getResource(resourceName);
        Path path = Paths.get(resource.toURI());
        return Files.readAllLines(path).stream().collect(Collectors.joining());
    }
}
