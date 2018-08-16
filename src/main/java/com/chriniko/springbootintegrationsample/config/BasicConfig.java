package com.chriniko.springbootintegrationsample.config;

import com.chriniko.springbootintegrationsample.dto.Input;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;

@Configuration
public class BasicConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {

        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        //all the classes the context needs to know about
        //"alternatively" setContextPath(<jaxb.context>)
        marshaller.setClassesToBeBound(Input.class);

        marshaller.setMarshallerProperties(new HashMap<String, Object>() {{
            put(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);
        }});

        return marshaller;

    }

}
