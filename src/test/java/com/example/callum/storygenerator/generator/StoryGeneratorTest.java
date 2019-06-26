package com.example.callum.storygenerator.generator;

import static org.junit.Assert.*;

import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StoryGeneratorTest
{

	private static final Logger logger = LoggerFactory.getLogger(StoryGeneratorTest.class );

	@Test
	public void testGetStartOfNextKey()
	{
		StoryGenerator sg = new StoryGenerator();
		// Check 3 words
		assertEquals("Result", "two three", sg.getStartOfNextKey("one two three"));
		// 4 words
		assertEquals("Result", "two three four", sg.getStartOfNextKey("one two three four"));
		// Space at end of input key
		assertEquals("Result", "two three four", sg.getStartOfNextKey("one two three four "));
	}

	@Test
	public void testGetRandom()
	{
		StoryGenerator sg = new StoryGenerator();
		int number = sg.getRandom(8);
		// Make sure random number is always between 0 and 7
		assertTrue(number >= 0 && number < 8);

		number = sg.getRandom(1000);
		// Make sure random number is always between 0 and 999
		assertTrue(number >= 0 && number < 999);

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetRandomException()
	{
		StoryGenerator sg = new StoryGenerator();
		// Make sure negative numbers throw IllegalArgumentException
		sg.getRandom(-1);
		// Make sure 0 throws IllegalArgumentException
		sg.getRandom(0);
	}

	@Test
	public void testGenerateStory()
	{
		// Check we generate a StringBuffer
		MultiValueMap map = new MultiValueMap();
		DataReader dr = new DataReader();
		map = dr.readData("testFiles/AliceInWonderland.txt", 3);
		StoryGenerator sg = new StoryGenerator();
		StringBuffer output = sg.generateStory(map, 1, 1, 7);

		logger.info(output.toString());

		// Check output is there
		assertTrue(output.length() > 0);
	}
}
