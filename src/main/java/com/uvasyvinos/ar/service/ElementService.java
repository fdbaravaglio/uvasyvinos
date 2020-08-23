package com.uvasyvinos.ar.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uvasyvinos.ar.controller.SomeController;
import com.uvasyvinos.ar.domain.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class ElementService {
    private static final Logger LOG = LoggerFactory.getLogger(SomeController.class);

    @Value("${source.url}")
    private String source;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper jsonMapper;

    public List<Element> getAllElements() {
        LOG.info("Requesting information to url: {}", source);

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(source, String.class);
        String body = Objects.requireNonNull(responseEntity.getBody());

        if (body.charAt(0) != '[') {
            body = body.substring(1);
        }

        List<Element> elementList = null;
        try {
            elementList = jsonMapper.readValue(body, new TypeReference<List<Element>>() {});
            LOG.info("Data un-marshalled successfully");
        } catch (IOException e) {
            System.out.println("Error while un-marshalling json object");
        }

        return elementList;
    }

}
