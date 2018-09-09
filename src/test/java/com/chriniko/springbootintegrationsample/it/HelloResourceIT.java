package com.chriniko.springbootintegrationsample.it;

import com.chriniko.springbootintegrationsample.dto.Input;
import com.chriniko.springbootintegrationsample.dto.Name;
import com.chriniko.springbootintegrationsample.dto.Output;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class HelloResourceIT extends IntegrationTest {

    @Test
    public void hello_works_as_expected() {

        // given
        Name name = new Name();
        name.setName("Chriniko");
        HttpEntity<Name> httpEntity = new HttpEntity<>(name);

        // when
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:" + apiPort + "/hello",
                HttpMethod.POST,
                httpEntity,
                String.class
        );

        // then
        Assert.assertNotNull(responseEntity);

        String body = responseEntity.getBody();

        String expected = "Hello Chriniko!!!".toLowerCase();
        Assert.assertEquals(expected, body.toLowerCase());

    }

    @Test
    public void hello_resource_tracker_works_as_expected() throws Exception {

        // given
        IntStream.rangeClosed(1, 10)
                .forEach(idx -> {

                    Name name = new Name();
                    name.setName("Chriniko");
                    HttpEntity<Name> httpEntity = new HttpEntity<>(name);

                    restTemplate.exchange(
                            "http://localhost:" + apiPort + "/hello",
                            HttpMethod.POST,
                            httpEntity,
                            String.class
                    );
                });

        TimeUnit.SECONDS.sleep(6);

        // when
        ResponseEntity<List<String>> responseEntity = restTemplate.exchange(
                "http://localhost:" + apiPort + "/tracker/messages",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<String>>() {
                }
        );

        // then
        Assert.assertNotNull(responseEntity);

        List<String> messages = responseEntity.getBody();
        Assert.assertEquals(10, messages.size());

        for (String message : messages) {
            Assert.assertEquals(
                    "Hello Chriniko!!!".toLowerCase(),
                    message.toLowerCase()
            );
        }
    }

    @Test
    public void sample_works_as_expected() throws Exception {

        // given
        Input input = new Input("foo", true, 1.2);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "application/json");
        HttpEntity<Input> httpEntity = new HttpEntity<>(input, httpHeaders);

        // when
        ResponseEntity<Output> responseEntity = restTemplate.exchange(
                "http://localhost:" + apiPort + "/sample",
                HttpMethod.POST,
                httpEntity,
                Output.class
        );

        // then
        Assert.assertNotNull(responseEntity);

        Output output = responseEntity.getBody();
        List<Output.Pair> results = output.getResults();

        Assert.assertEquals(5, results.size());

        String expected = loadResource("outcome/sampleGatewayResponse.json");
        String outputAsString = objectMapper.writeValueAsString(output);

        JSONAssert.assertEquals(expected, outputAsString, true);
    }
}
