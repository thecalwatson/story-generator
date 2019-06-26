package com.example.callum.storygenerator.generator;

import org.apache.commons.collections.map.MultiValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GeneratorService {
    @Value("${inFile}")
    private String inputFile;
    @Value("${outFile}")
    private String outFile;
    @Value("${nGramFactor}")
    private int nGramFactor;
    @Value("${numberOfParagraphs}")
    private int numberOfParagraphs;
    @Value("${numberOfSentences}")
    private int numberOfSentences;
    @Value("${numberOfWordsInSentence}")
    private int numberOfWordsInSentence;

    private static final Logger logger = LoggerFactory.getLogger(GeneratorService.class);
    private MultiValueMap storyDataMap = new MultiValueMap();

    public MultiValueMap getStoryDataMap() {
        return this.storyDataMap;
    }

    public void generateStory() {
        DataReader dr = new DataReader();
        this.storyDataMap = dr.readData(inputFile, nGramFactor);
        StoryGenerator sg = new StoryGenerator();
        StringBuffer sb = sg.generateStory(storyDataMap, numberOfParagraphs, numberOfSentences, numberOfWordsInSentence);
        StoryWriter sr = new StoryWriter();
        sr.writeStory(outFile, sb);
    }
}
