package com.example.callum.storygenerator.generator;

import static org.junit.Assert.*;

import org.apache.commons.collections.map.MultiValueMap;
import org.junit.Test;

public class DataReaderTest
{

	@Test
	public void testReadData()
	{
		// Read file with line "I wish I may I wish I might" and store in map
		MultiValueMap map = new MultiValueMap();
		DataReader dr = new DataReader();
		map = dr.readData("testFiles/simpleInput.txt", 3);

		// Check map has expected number of keys which is 6
		assertEquals("Result", 4, map.size());
		// Check map has expected number of values which is 8
		assertEquals("Result", 6, map.totalSize());

		// Check contents of map
		assertEquals("Result", "{I wish=[I, I], may I=[wish], I may=[I], wish I=[may, might]}", map.toString());
	}

	@Test
	public void testGetNumberOfNgrams()
	{
		DataReader dr = new DataReader();
		//Check formula for number of n-grams
		assertEquals("Result", 6, dr.getNumberOfNgrams(8, 3));
		assertEquals("Result", 7, dr.getNumberOfNgrams(8, 2));
		assertEquals("Result", 8, dr.getNumberOfNgrams(8, 1));
		assertEquals("Result", 5, dr.getNumberOfNgrams(8, 4));
		assertEquals("Result", 1232, dr.getNumberOfNgrams(1234, 3));
	}

}
