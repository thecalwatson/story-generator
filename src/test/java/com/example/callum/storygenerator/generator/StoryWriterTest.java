package com.example.callum.storygenerator.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;

public class StoryWriterTest
{

    @Test
    public void testWriteStory() throws IOException
    {
        String outputFileName = "testFiles/simpleOutput.txt";
        int numParagraphs = 3;
        int numSentences = 5;

        MultiValueMap map = new MultiValueMap();
        DataReader dr = new DataReader();
        map = dr.readData("testFiles/simpleInput.txt", 3);

        StoryGenerator sg = new StoryGenerator();
        StringBuffer sb = sg.generateStory(map, numParagraphs, numSentences, 5);

        StoryWriter sr = new StoryWriter();
        sr.writeStory(outputFileName, sb);

        // Check file exists
        File result = new File(outputFileName);
        assertTrue(result.exists());

        // Check file is not empty i.e. has a story in it
        FileReader fr = new FileReader(outputFileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        assertTrue(line != null);

        // Check number of paragraphs and total number of sentences
        int countParas = 0, countSentences = 0;
        while (line != null)
        {
            // Only count lines with data on them
            if (line.length() != 0)
            {
                countParas++;
                int charCount = line.length() - line.replaceAll("\\.","").length();
                countSentences = countSentences + charCount;
            }
            line = br.readLine();
        }
        assertEquals("Result", numParagraphs, countParas);
        assertEquals("Result", numSentences*numParagraphs, countSentences);
    }

}
