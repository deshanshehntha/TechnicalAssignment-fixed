package com.exercise.demo;


import com.exercise.demo.model.CalculatedPriceRequestObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RequestMappingTests {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testCreateStudent() throws Exception {
        CalculatedPriceRequestObject obj = new CalculatedPriceRequestObject();
        obj.setProduct("PenguinEars");
        obj.setQty("100");
        HttpEntity<CalculatedPriceRequestObject> entity = new HttpEntity<CalculatedPriceRequestObject>(obj, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/getCalculatedPrice"), HttpMethod.POST, entity, String.class);
        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        assertTrue(actual.contains("/api/getCalculatedPrice"));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}