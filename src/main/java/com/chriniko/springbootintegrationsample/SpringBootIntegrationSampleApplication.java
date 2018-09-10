package com.chriniko.springbootintegrationsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication

@ImportResource(
        {
                "classpath:integration-1.xml",
                "classpath:integration-2.xml",
                "classpath:integration-3.xml",
                "classpath:integration-4.xml"
        }
)
public class SpringBootIntegrationSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootIntegrationSampleApplication.class, args);
    }
}
