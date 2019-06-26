package com.example.callum.storygenerator.generator;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringFormatterTest {

    @Test
    public void stripPunctuation() {
        // Removal of everything bar letters integers
        assertEquals("Result", "TestWord123", StringFormatter.stripPunctuation("T|e'&$£st//W-o--+rd^£1/2`3"));
        // Do spaces remain
        assertEquals("Result", "3 test words", StringFormatter.stripPunctuation("3 test words"));
        assertEquals("Result", "3 test words", StringFormatter.stripPunctuation("3 test words"));
    }

    @Test
    public void testLowerCase()
    {
        // Change word to lowercase
        assertEquals("Result", "test words with mixed case", StringFormatter.lowerCase("TeSt WORDs with MiXeD CAsE"));
        // Instance of I/i mid sentence is uppercase
        assertEquals("Result", "hello I am here", StringFormatter.lowerCase("Hello I am here"));
        assertEquals("Result", "hello I am here", StringFormatter.lowerCase("Hello i am here"));
        // Instance of I/i at start of line is uppercase
        assertEquals("Result", "I am here", StringFormatter.lowerCase("I am here"));
        assertEquals("Result", "I am here", StringFormatter.lowerCase("i am here"));
        // Instance of I and end of line (followed by full stop) is uppercase
        assertEquals("Result", "tired am I.", StringFormatter.lowerCase("tired am I."));
        assertEquals("Result", "tired am I.", StringFormatter.lowerCase("tired am i."));
        // Word beginning with I at start of line is lowercase
        assertEquals("Result", "in here I am", StringFormatter.lowerCase("In here I am"));
    }

    @Test
    public void testCapitalizeWord()
    {
        // Capitalization of word
        assertEquals("Result", "Hello", StringFormatter.capitalizeWord("hello"));
        // What about 2 words
        assertEquals("Result", "Hello world", StringFormatter.capitalizeWord("hello world"));
        // Word already capitalized should remain
        assertEquals("Result", "Hello", StringFormatter.capitalizeWord("Hello"));
    }
}