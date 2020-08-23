package com.uvasyvinos.ar.controller;

import com.uvasyvinos.ar.domain.Element;
import com.uvasyvinos.ar.service.ElementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/elements")
public class SomeController {
    private static final Logger LOG = LoggerFactory.getLogger(SomeController.class);

    @Autowired
    private ElementService elementService;

    @GetMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<Element>> getAllElements() {
        return new ResponseEntity<>(elementService.getAllElements(), HttpStatus.OK);
    }
}
