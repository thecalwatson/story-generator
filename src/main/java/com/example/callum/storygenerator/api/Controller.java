package com.example.callum.storygenerator.api;

import com.example.callum.storygenerator.generator.GeneratorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    private final GeneratorService generatorService;

    @Autowired
    public Controller(GeneratorService generatorService) {
        this.generatorService = generatorService;
    }

    @GetMapping("/hello")
    public String retrieve() {
        logger.info("HELLO REQUEST RECEIVED");
        return "Hello";
    }

    @GetMapping("/generate")
    public String generate() {
        logger.info("STORY GENERATION REQUEST RECEIVED");
        generatorService.generateStory();
        return "Generated new story at your request";
    }
}

