package com.example.callum.storygenerator.generator;

import org.apache.commons.collections.map.MultiValueMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

/*
 * Generate story using given dataset
 */
public class StoryGenerator
{
	private static final Logger logger = LoggerFactory.getLogger(StoryGenerator.class );

	/*
	 * Generate story using data in given map
	 */
	public StringBuffer generateStory(MultiValueMap multiMap, int numParagaraphs, int numSentences, int numWords)
	{
		logger.info("Generating Story");

		// Buffer to hold the data
		StringBuffer sb = new StringBuffer();

		// Put all the keys in a array
		Object[] keys = multiMap.keySet().toArray();

		// Something to hold current key and value in
		String key, value;

		// For the number of paragraphs in story
		for (int x = 0; x < numParagaraphs; x++)
		{
			// For the number of sentences we want to generate
			for (int y = 0; y < numSentences; y++)
			{
				// Select a random key to start with
				int randomInt = getRandom(multiMap.size());
				key = (String) keys[randomInt];

				// Add key as first word of sentence with capital letter
				String firstWord = StringFormatter.capitalizeWord(key);
				sb.append(firstWord);

				// Set value to empty String
				value = "";

				// Get the rest of the words to make up the sentence
				for (int i = 0; i < numWords - 2; i++)
				{
					// Look up map for a random value to go with key
					if (multiMap.containsKey(key))
					{
						// Get corresponding values from map using key
						ArrayList<?> values = (ArrayList<?>) multiMap.get(key);

						// Need random value from list of possibilities
						value = (String) values.get(getRandom(values.size()));

						// Add value to output
						sb.append(" " + value);

						// Update new key value to use to get next word
						key = getStartOfNextKey(key) + " " + value;
					}
					// If map doesn't have key can't extend sentence further
					else
						break;
				}

				// Add full stop to end of each line
				sb.append(". ");
			}
			// Add new paragraph spacing if not on last paragraph already
			if (x < numParagaraphs - 1)
				sb.append("\n\n");
		}
		return sb;
	}

	/*
	 * Return start of next key
	 */
	public String getStartOfNextKey(String key)
	{
		StringBuffer keyStart = new StringBuffer();

		// Array of words in key
		String[] words = key.split(" ");
		// Generate all words without the first word of the original key
		for (int i = 1; i < words.length; i++)
		{
			keyStart.append(words[i]);
			// put space between words unless last word getting added
			if (i < words.length - 1)
				keyStart.append(" ");
		}

		return keyStart.toString();
	}

	/*
	 * Return random integer between 0 and upperLimit - 1
	 */
	public int getRandom(int upperLimit)
	{
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(upperLimit);
		return randomInt;
	}

}
