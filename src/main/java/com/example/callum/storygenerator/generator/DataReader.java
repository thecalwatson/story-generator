package com.example.callum.storygenerator.generator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.collections.map.MultiValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataReader
{
    private static final Logger logger = LoggerFactory.getLogger(DataReader.class);

    public MultiValueMap readData(String inputFile, int nGramFactor)
    {
        logger.info("Reading from file: " + inputFile);
        MultiValueMap map = new MultiValueMap();

        try
        {
            FileReader fr = new FileReader(inputFile);
            BufferedReader br = new BufferedReader(fr);
            int lineCount = 0, nGramCount = 0;

            String line = br.readLine();

            while (line != null)
            {
                lineCount++;

                line = StringFormatter.lowerCase(line);
                line = StringFormatter.stripPunctuation(line);

                // Store individual words in array
                String[] words = line.split(" ");

                // Determine the number of key value pairs we expect to generate
                nGramCount = getNumberOfNgrams(words.length, nGramFactor);

                // For each n-gram
                for (int i = 0; i < nGramCount; i++)
                {
                    // Loop to build key depending on factor
                    String key = words[i];
                    for (int x = 0, y = i + 1; x < nGramFactor - 2; x++)
                    {
                        key = key + " " + words[y];
                        y++;
                    }
                    // Add key and next word to map
                    map.put(key, words[i + nGramFactor - 1]);
                }
                // Read next line
                line = br.readLine();
            }
            br.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        logger.debug("Number of keys in map = " + map.size());
        logger.debug("Number of values in map = " + map.totalSize());
        return map;
    }

    /*
     * Method to calculate the number of n-grams for given word count and factor
     */
    public int getNumberOfNgrams(int wordCount, int nGramFactor)
    {
        return wordCount - (nGramFactor - 1);
    }
}
